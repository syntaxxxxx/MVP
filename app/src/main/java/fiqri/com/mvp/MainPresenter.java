package fiqri.com.mvp;

    class MainPresenter {
    private MainView view;

    MainPresenter(MainView view) {
        this.view = view;
    }

    private double luas(double alas, double tinggi) {
        return alas * tinggi / 2;
    }

    void hitungLuas(double alas, double tinggi) {
        double luas = luas(alas, tinggi);
        MainModel model = new MainModel(luas);
        view.nampilinLuas(model);
    }
}
