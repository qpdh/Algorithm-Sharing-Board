package org.tukorea.free.domain;




public class LanguageVO {
    private String language;

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "LanguageVO [language=" + language + "]";
	}

	public LanguageVO(String language) {
		super();
		this.language = language;
	}

	public LanguageVO() {
		super();
	}
    
    

}
