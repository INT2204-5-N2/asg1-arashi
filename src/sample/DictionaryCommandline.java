package sample;


class DictionaryCommandLine {

    public static void dictionaryAdvanced() {
        DictionaryManagement h = new DictionaryManagement();
        h.insertFromFile();
        h.showAllWords();
        h.Searcher();
        h.delete();
        h.change();
    }

    public static void main(String[] args) {
        DictionaryCommandLine dc = new DictionaryCommandLine();
        dc.dictionaryAdvanced();

    }
}
