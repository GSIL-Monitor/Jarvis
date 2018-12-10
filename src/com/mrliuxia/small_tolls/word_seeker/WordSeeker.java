package com.mrliuxia.small_tolls.word_seeker;

import com.mrliuxia.util.FileUtil;
import com.mrliuxia.util.StringUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/10/9
 */
public class WordSeeker {

    public static void main(String[] args) {
        WordSeeker wordSeeker = new WordSeeker();
        String miniDic = "/Users/netease/Workspace/Github/ECDICT-master/ecdict.mini.csv";
        String totalDic = "/Users/netease/Workspace/Github/ECDICT-master/ecdict.csv";
//        String targetWord = "";
        String targetPattern = "j.*v.*";
//        String targetPattern = ".*sh.*l.*";
//        String targetPattern = ".*sh.*a.*";
        try {
            wordSeeker.seekPattern(targetPattern, totalDic);
//            wordSeeker.seek(totalDic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void seek(String path) throws IOException {
        if (StringUtil.isEmpty(path)) {
            return;
        }
        BufferedReader reader = FileUtil.getFileReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            try {
                Word word = new Word.Builder(data[0])
                        .phonetic(data[1])
                        .definition(data[2])
                        .translation(data[3])
                        .build();
                String currWord = data[0];
                if (!currWord.contains(" ") && currWord.contains("li") && currWord.contains("u") && currWord.length() < 6) {
                    System.out.println(word);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("data="+line);
                exception.printStackTrace();
                continue;
            }
        }
    }

    public void seekWord(String target, String path) throws IOException {
        if (StringUtil.isEmpty(target) || StringUtil.isEmpty(path)) {
            return;
        }
        BufferedReader reader = FileUtil.getFileReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            try {
                Word word = new Word.Builder(data[0])
                        .phonetic(data[1])
                        .definition(data[2])
                        .translation(data[3])
                        .build();
                if (!word.getWord().contains(" ") && word.getWord().contains(target)) {
                    System.out.println(word);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("data="+line);
                exception.printStackTrace();
                continue;
            }
        }
    }

    public void seekPattern(String wordPattern, String path) throws IOException {
        if (StringUtil.isEmpty(wordPattern) || StringUtil.isEmpty(path)) {
            return;
        }
        BufferedReader reader = FileUtil.getFileReader(path);
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            try {
                Word word = new Word.Builder(data[0])
                        .phonetic(data[1])
                        .definition(data[2])
                        .translation(data[3])
                        .build();
                if (!word.getWord().contains(" ") && Pattern.matches(wordPattern, word.getWord()) ) {
                    System.out.println(word);
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("data="+line);
                exception.printStackTrace();
                continue;
            }
        }
        return;
    }

}
