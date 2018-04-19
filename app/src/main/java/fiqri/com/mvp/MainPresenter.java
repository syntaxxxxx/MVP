package fiqri.com.mvp;

public class MainPresenter {
    private MainView view;

    public MainPresenter(MainView view) {
        this.view = view;
    }

    public double luas(double alas, double tinggi) {
        return alas * tinggi / 2;
    }

    public void hitungLuas(double alas, double tinggi) {
        double luas = luas(alas, tinggi);
        MainModel model = new MainModel(luas);
        view.nampilinLuas(model);
    }
}
