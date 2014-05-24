package apt.model;

import java.io.Serializable;

public class Directory implements Serializable {

    private Directory parent;
    private String name;
    private String folderName;


    public String getPath() {
        if (this.parent == null) {
            return this.folderName;
        }
        else {
            return this.parent.getPath() + "/" + this.folderName;
        }
    }


    public Directory getParent() {
        return parent;
    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }
}
