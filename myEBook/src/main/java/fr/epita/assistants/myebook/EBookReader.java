package fr.epita.assistants.myebook;

import org.apache.commons.lang3.ObjectUtils;

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
    }
    @Override
    public void openToPage(int page) {
        if (ebook != null)
            ebook.openToPage(page);
    }

    @Override
    public int getCurrentPage() {
        if (ebook != null)
            return ebook.getCurrentPage();
        return -1;
    }

    @Override
    public int getPageCount() {
        if (ebook != null)
            return ebook.pages.size();
        return -1;
    }

    @Override
    public double getVersion() {
        return version;
    }

    @Override
    public void update(double _version) {
        if (_version > version)
            version = _version;
    }

    @Override
    public String readCurrentPage() {
        return ebook.readCurrentPage();
    }
}
