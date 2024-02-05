package fr.epita.assistants.myebook;

public class EBookReader implements IPaginated, IUpdatable, IReadable{
    private double version;
    private EBook ebook;
    public EBookReader(){
        version = 1.0;
    }
    private int onPage;
    public void openEbook(EBook _ebook)
    {
        ebook = _ebook;
        onPage = 0;
    }
    @Override
    public void openToPage(int page) {
        if (page < getPageCount())
            onPage = page;
    }

    @Override
    public int getCurrentPage() {
        return onPage;
    }

    @Override
    public int getPageCount() {
       return ebook.pages.size();
    }

    @Override
    public double getVersion() {
        return version;
    }

    @Override
    public void update(double _version) {
        version = _version;
    }

    @Override
    public String readCurrentPage() {
        return ebook.readCurrentPage();
    }
}
