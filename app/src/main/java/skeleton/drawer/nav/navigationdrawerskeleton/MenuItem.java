package skeleton.drawer.nav.navigationdrawerskeleton;

public class MenuItem {
    private String title;
    private boolean isEnabled;

    public MenuItem(String mTitle, boolean isEnabled) {
        this.title = mTitle;
        this.isEnabled = isEnabled;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String mTitle) {
        this.title = mTitle;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
    }
}
