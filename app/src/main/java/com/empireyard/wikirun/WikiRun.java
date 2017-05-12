package com.empireyard.wikirun;

/**
 * Created by osk on 04.02.17.
 */

public class WikiRun {

    String wikiURL;

    public WikiRun(String languageShortcut) { //languageShortcut f.e.: en, pl
        this.wikiURL = "https://" + languageShortcut + ".m.wikipedia.org/wiki/";
    }

    public void setWikiLanguage(String languageShortcut) {
        this.wikiURL = "https://" + languageShortcut + ".m.wikipedia.org/wiki/";
	////example comment on debug branch
    ////example comment written online on www
    }
}
