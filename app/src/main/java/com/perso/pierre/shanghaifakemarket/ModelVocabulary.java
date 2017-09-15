package com.perso.pierre.shanghaifakemarket;

/**
 * Created by Pierre on 17/12/2015.
 */
public class ModelVocabulary {

    private String englishSentence;
    private String pinyinSentence;
    private Integer speaking;



    public ModelVocabulary() {
    }

    public ModelVocabulary(String englishSentence, String pinyinSentence, Integer speaking) {
        this.englishSentence = englishSentence;
        this.pinyinSentence = pinyinSentence;
        this.speaking = speaking;
    }

    public ModelVocabulary(String englishSentence, String pinyinSentence) {
        this.englishSentence = englishSentence;
        this.pinyinSentence = pinyinSentence;
    }

    public Integer getSpeaking() {
        return speaking;
    }

    public void setSpeaking(Integer speaking) {
        this.speaking = speaking;
    }

    public String getEnglishSentence() {
        return englishSentence;
    }

    public void setEnglishSentence(String englishSentence) {
        this.englishSentence = englishSentence;
    }

    public String getPinyinSentence() {
        return pinyinSentence;
    }

    public void setPinyinSentence(String pinyinSentence) {
        this.pinyinSentence = pinyinSentence;
    }
}
