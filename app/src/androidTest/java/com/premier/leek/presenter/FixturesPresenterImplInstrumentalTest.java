package com.premier.leek.presenter;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.premier.leek.model.FixtureDisplayableItem;
import com.premier.leek.util.Utilities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class FixturesPresenterImplInstrumentalTest {

    private Context instrumentalContext;
    @Before
    public void setup() {
        instrumentalContext = InstrumentationRegistry.getContext();
    }
    @Test
    public void loadNextFixtures() throws Exception {
        FixturesPresenter fixturesPresenter = new FixturesPresenterImpl(instrumentalContext);
        List<FixtureDisplayableItem> fixtureDisplayableItems = fixturesPresenter.loadNextFixtures();
        if (Utilities.checkForInternetConnection(instrumentalContext)) {
            Assert.assertTrue(fixtureDisplayableItems.size() > 0);
        } else {
            Assert.assertTrue(fixtureDisplayableItems.size() == 0);
        }
    }

}