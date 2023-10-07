package ru.absdev.document;

public abstract class Document {
    protected String ownerName;
    protected final int docCode;
    protected DocStatus status;

    public Document(int docCode, String ownerName) {
        this.ownerName = ownerName;
        this.docCode = docCode;
        this.status = DocStatus.ACCEPT;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public int getDocCode() {
        return docCode;
    }

    public DocStatus getStatus() {
        return status;
    }

    public void setStatus(DocStatus status) {
        this.status = status;
    }
}
