package fiqri.com.mvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class MainPresenterTest {

    @Mock
    private MainPresenter presenter;
    private MainView view;

    @Before
    public void setUp() throws Exception {
        view = mock(MainView.class);
        presenter = new MainPresenter(view);
    }

    @Test
    public void testIntegerInput() throws Exception {
        double volume = presenter.hitungLuas(2.1, 2.1);
        assertEquals(2.205, volume, 0.0001);
    }

    @Test
    public void testZeroInput() throws Exception {
        double volume = presenter.hitungLuas(0, 0);
        assertEquals(0.0, volume, 0.0001);
    }
}
