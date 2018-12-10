package com.mrliuxia.small_tolls.word_seeker;

/**
 * Description:
 * Author: liuxiao
 * Date: 2018/10/9
 */
public class Word {

    private String word;        // 单词名称
    private String phonetic;    // 音标
    private String definition;  // 单词英文释义
    private String translation; // 单词中文释义
    private String pos;         // 词语位置
    private String collins;     // 柯林斯星级
    private String oxford;      // 是否是牛津三千核心词汇
    private String tag;         // 字符串标签，zk中考、gk高考、cet4四级等
    private String bnc;         // 英语国家语料库词频顺序
    private String frq;         // 当代语料库词频顺序
    private String exchange;    // 时态复数等变换
    private String detail;      // 扩展信息，例句等
    private String audio;       // 读音音频url

    private Word(Builder builder) {
        this.word = builder.word;
        this.phonetic = builder.phonetic;
        this.definition = builder.definition;
        this.translation = builder.translation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Word) {
            return ((Word) obj).word.equals(this.word);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + ": " + translation;
    }

    public String getWord() {
        return word;
    }

    public String getPhonetic() {
        return phonetic;
    }

    public String getDefinition() {
        return definition;
    }

    public String getTranslation() {
        return translation;
    }

    public String getPos() {
        return pos;
    }

    public String getCollins() {
        return collins;
    }

    public String getOxford() {
        return oxford;
    }

    public String getTag() {
        return tag;
    }

    public String getBnc() {
        return bnc;
    }

    public String getFrq() {
        return frq;
    }

    public String getExchange() {
        return exchange;
    }

    public String getDetail() {
        return detail;
    }

    public String getAudio() {
        return audio;
    }

    public static class Builder {

        private String word;
        private String phonetic;
        private String definition;
        private String translation;
        private String pos;
        private String collins;
        private String oxford;
        private String tag;
        private String bnc;
        private String frq;
        private String exchange;
        private String detail;
        private String audio;

        public Builder(String word) {
            this.word = word;
        }

        public Builder phonetic(String phonetic) {
            this.phonetic = phonetic;
            return this;
        }

        public Builder definition(String definition) {
            this.definition = definition;
            return this;
        }

        public Builder translation(String translation) {
            this.translation = translation;
            return this;
        }

        // TODO: 2018/10/9 else builder

        public Word build() {
            return new Word(this);
        }

    }



}
