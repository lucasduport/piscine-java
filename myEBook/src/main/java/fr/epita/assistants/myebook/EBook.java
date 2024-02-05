package fr.epita.assistants.myebook;

import java.util.ArrayList;
import java.util.List;

public final class EBook extends Book implements IEditable, IPaginated{

    public String getName() {
        return this.name;
    }

    public EBook(String _name)
    {
        super(_name, new ArrayList<>());
        this.openedOn = -1;
        this.addPage();
        this.openedOn = 0;
    }
    public EBook(String _name, List<String> _pages) {
        super(_name, _pages);
    }

    @Override
    public void writeCurrentPage(String pageText) {
        int onPage = this.getCurrentPage();
        this.pages.remove(onPage);
        this.pages.add(onPage, pageText);

    }

    @Override
    public void addPage() {
        this.pages.add(this.getCurrentPage() + 1, "");
    }

    @Override
    public void deletePage() {
        if (this.getCurrentPage() < this.getPageCount())
            this.pages.remove(this.getCurrentPage());
        if (this.getPageCount() == 0)
            this.addPage();
        return;
    }

    public Book print()
    {
        return new Book(name, pages);
    }
}
