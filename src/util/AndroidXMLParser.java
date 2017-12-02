package util;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: liuxiao
 * Created: 2017/10/20 10:16
 * Description:
 */
public class AndroidXMLParser {

    private static final String STRING_REPLACE_FLAG = "string/";

    private Map<String, String> dictionaryMap;
    private Map<String, String> waitingMap;

    public AndroidXMLParser() {
        dictionaryMap = new HashMap<>();
        waitingMap = new HashMap<>();
    }

    public void doDynamicReplace(String path) {
        String originPath, tempPath;
        if (path == null || path.length() == 0) {
            originPath = "/Users/Poker/Workspace/IdeaProjects/Poker_Java/doc/strings.xml";
        } else {
            originPath = path;
        }
        tempPath = originPath + ".temp";
        File originFile = new File(originPath);
        if (!originFile.exists()) {
            return;
        }

        File tempFile = new File(tempPath);
        originFile.renameTo(tempFile);
        parseXMLFileToMap(tempFile);
        replaceMapString();
        writeMapToFile(originPath);
        doRevert("");
    }

    public void doRevert(String path) {
        String originPath, tempPath;
        if (path == null || path.length() == 0) {
            originPath = "/Users/Poker/Workspace/IdeaProjects/Poker_Java/doc/strings.xml";
        } else {
            originPath = path;
        }
        tempPath = originPath + ".temp";
        File tempFile = new File(tempPath);
        tempFile.renameTo(new File(originPath));
    }

    private void parseXMLFileToMap(File file) {
        if (!file.exists()) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String lineContent, key, value;
            while ((lineContent = reader.readLine()) != null) {
                lineContent = lineContent.trim();
                if (!lineContent.startsWith("<string")) {
                    System.out.println("skip: " + lineContent);
                    continue;
                }
                try {
                    key = lineContent.split("\"")[1];
                    value = lineContent.split(">")[1].split("<")[0];
                    dictionaryMap.put(key, value);
                    if (value.contains(STRING_REPLACE_FLAG)) {
                        waitingMap.put(key, value);
                    }
                } catch (Exception e) {
                    System.out.println("error line: " + lineContent);
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void replaceMapString() {
        for (Map.Entry<String, String> entry : waitingMap.entrySet()) {
            dictionaryMap.put(entry.getKey(), replaceStringSymble(entry.getValue()));
        }
    }

    private String parseMapToString(Map<String, String> map, String xmlName) {
        StringBuilder sb = new StringBuilder();
        sb.append("<resources>\n");
        for (Map.Entry entry : map.entrySet()) {
            sb.append("    <string name=\"")
                    .append(entry.getKey())
                    .append("\">")
                    .append(entry.getValue())
                    .append("</string>\n");
        }
        sb.append("</resources>");
        return sb.toString();
    }

//    private String replaceStringSymble(String originStr) {
//        boolean keyFlag = false;
//        String key = "";
//        int keyStartIndex = -1, keyLength = 1;
//        StringBuilder result = new StringBuilder();
//        char[] sequence = originStr.toCharArray();
//        for (int i = 0; i < sequence.length; i++) {
//            if (sequence[i] == '+' && checkFlag(sequence, i + 1)) {
//                keyFlag = true;
//                i = i + STRING_REPLACE_FLAG.length() + 1;
//                keyStartIndex = i;
//            } else if (i + STRING_REPLACE_FLAG.length() - 1 < sequence.length && checkFlag(sequence, i)) {
//                keyFlag = true;
//                i = i + STRING_REPLACE_FLAG.length();
//                keyStartIndex = i;
//            } else if (keyFlag) {
//                if (sequence[i] == '+' || i == sequence.length - 1) {
//                    key = new String(sequence, keyStartIndex, ++keyLength);
////                    result.append("kkk");
//                    if (dictionaryMap.containsKey(key)) {
//                        result.append(dictionaryMap.get(key));
//                    }
//                    keyStartIndex = -1;
//                    keyLength = 1;
//                    keyFlag = false;
//                    key = "";
//                } else {
//                    keyLength++;
//                }
//            } else {
//                result.append(sequence[i]);
//            }
//        }
//
//        return result.toString();
//    }

    private String replaceStringSymble(String originStr) {
        boolean keyFlag = false;
        String key = "";
        int keyStartIndex = -1, keyLength = 0;
        StringBuilder result = new StringBuilder();
        char[] sequence = originStr.toCharArray();
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == '+' && checkFlag(sequence, i + 1)) {
                keyFlag = true;
                i = i + STRING_REPLACE_FLAG.length() + 1;
                keyStartIndex = i;
            } else if (i + STRING_REPLACE_FLAG.length() - 1 < sequence.length && checkFlag(sequence, i)) {
                keyFlag = true;
                i = i + STRING_REPLACE_FLAG.length();
                keyStartIndex = i;
            } else if (keyFlag) {
                if (i == sequence.length - 1) {
                    key = new String(sequence, keyStartIndex, ++keyLength + 1);
                    System.out.println("key=" + key);
//                    result.append("kkk");
                    if (dictionaryMap.containsKey(key)) {
                        result.append(dictionaryMap.get(key));
                    }
                    keyStartIndex = -1;
                    keyLength = 0;
                    keyFlag = false;
                    key = "";
                } else if (sequence[i] == '+') {
                    key = new String(sequence, keyStartIndex, ++keyLength);
                    System.out.println("key=" + key);
//                    result.append("kkk");
                    if (dictionaryMap.containsKey(key)) {
                        result.append(dictionaryMap.get(key));
                    }
                    keyStartIndex = -1;
                    keyLength = 0;
                    keyFlag = false;
                    key = "";
                } else {
                    keyLength++;
                }
            } else {
                result.append(sequence[i]);
            }
        }

        return result.toString();
    }

    private boolean checkFlag(char[] sequence, int startIndex) {
        if (startIndex + STRING_REPLACE_FLAG.length() - 1 < sequence.length
                && (new String(sequence, startIndex, STRING_REPLACE_FLAG.length())).equals(STRING_REPLACE_FLAG)) {
            return true;
        }
        return false;
    }

    private void writeMapToFile(String path) {
        writeMapToFile(parseMapToString(dictionaryMap, "resources"), path);
    }

    private void writeMapToFile(String content, String path) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("util.AndroidXMLParser");
            Method method = clazz.getMethod("doDynamicReplace", String.class);
            method.invoke(clazz.newInstance(), "");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

//        char[] seq = "string/name+x+string/name+x+string/name".toCharArray();
//        System.out.println(new String(seq, 7, 4));
//        AndroidXMLParser parser = new AndroidXMLParser();
//        System.out.println(parser.replaceStringSymble("123+string/app_name+456+string/app_name+789", 1));
//        System.out.println(parser.replaceStringSymble("string/name+x+string/name+x+string/name", 1));
//        System.out.println(parser.replaceStringSymble("x+string/name+x+string/name", 1));
//        System.out.println(parser.replaceStringSymble("+string/name+x+string/name", 1));
//        System.out.println(parser.replaceStringSymble("+string/name+x+", 1));
//        System.out.println(parser.replaceStringSymble("+string/name+x", 1));

//        File file = new File(INPUT_PATH);
//        Map<String, String> originMap = parse(file);
//        PrintUtil.printMap(originMap);
//        write(originMap, "resource", OUTPUT_PATH);
    }


    private String replaceStringSymble(String originStr, int adsf) {
        boolean keyFlag = false;
        String key = "";
        int keyStartIndex = -1, keyLength = 0;
        StringBuilder result = new StringBuilder();
        char[] sequence = originStr.toCharArray();
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] == '+' && checkFlag(sequence, i + 1)) {
                keyFlag = true;
                i = i + STRING_REPLACE_FLAG.length() + 1;
                keyStartIndex = i;
            } else if (i + STRING_REPLACE_FLAG.length() - 1 < sequence.length && checkFlag(sequence, i)) {
                keyFlag = true;
                i = i + STRING_REPLACE_FLAG.length();
                keyStartIndex = i;
            } else if (keyFlag) {
                if (i == sequence.length - 1) {
                    key = new String(sequence, keyStartIndex, ++keyLength + 1);
                    System.out.println("key=" + key);
                    result.append("kkk");
//                    if (dictionaryMap.containsKey(key)) {
//                        result.append(dictionaryMap.get(key));
//                    }
                    keyStartIndex = -1;
                    keyLength = 0;
                    keyFlag = false;
                    key = "";
                } else if (sequence[i] == '+') {
                    key = new String(sequence, keyStartIndex, ++keyLength);
                    System.out.println("key=" + key);
                    result.append("kkk");
//                    if (dictionaryMap.containsKey(key)) {
//                        result.append(dictionaryMap.get(key));
//                    }
                    keyStartIndex = -1;
                    keyLength = 0;
                    keyFlag = false;
                    key = "";
                } else {
                    keyLength++;
                }
            } else {
                result.append(sequence[i]);
            }
        }

        return result.toString();
    }

}
