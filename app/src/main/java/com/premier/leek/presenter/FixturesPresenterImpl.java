package com.premier.leek.presenter;


import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.premier.leek.R;
import com.premier.leek.model.Fixture;
import com.premier.leek.model.FixtureDisplayableItem;
import com.premier.leek.model.FootballDataResponseModel;
import com.premier.leek.network.FixturesProvider;
import com.premier.leek.network.PremierLeagueFixturesProvider;
import com.premier.leek.sharedpref.SharedPreferenceManager;
import com.premier.leek.util.DateFormatterFactory;

import java.util.ArrayList;
import java.util.List;

public class FixturesPresenterImpl implements FixturesPresenter{

    private Context context;
    private FixturesProvider fixturesProvider;

    public FixturesPresenterImpl(Context context) {
        this.context = context;
    }

    @Override
    public List<FixtureDisplayableItem> loadNextFixtures() {
        List<FixtureDisplayableItem> displayableItems = new ArrayList<>();
        fixturesProvider = new PremierLeagueFixturesProvider();
        FootballDataResponseModel footballDataResponseModel = fixturesProvider.loadNextFixtures();
        if (footballDataResponseModel != null) {
            for (int i = 0; i < footballDataResponseModel.getFixtures().size(); i++) {
                Fixture currentFixture = footballDataResponseModel.getFixtures().get(i);
                if (i == 0 || !DateFormatterFactory.formatDateForDateSeparator(currentFixture.getDate()).
                        equals(DateFormatterFactory.formatDateForDateSeparator(footballDataResponseModel.getFixtures().
                                get(i - 1).getDate()))) {
                    FixtureDisplayableItem dateHeaderItem = new FixtureDisplayableItem();
                    dateHeaderItem.setDateHeader(true);
                    dateHeaderItem.setFixturesDateHeader(DateFormatterFactory.
                            formatDateForDateSeparator(currentFixture.getDate()));
                    displayableItems.add(dateHeaderItem);
                }
                displayableItems.add(buildFixtureDisplayableItem(currentFixture));
            }
        }
        return displayableItems;
    }

    private FixtureDisplayableItem buildFixtureDisplayableItem(Fixture currentFixture) {
        FixtureDisplayableItem displayableItem = new FixtureDisplayableItem();
        displayableItem.setHomeTeamName(currentFixture.getHomeTeamName());
        displayableItem.setAwayTeamName(currentFixture.getAwayTeamName());
        displayableItem.setFixtureId(currentFixture.getLinks().geFixtureIdLink().getHref());
        displayableItem.setAddedToFavorites(SharedPreferenceManager.getInstance().
                getBoolean(currentFixture.getLinks().geFixtureIdLink().getHref(), false));
        if (currentFixture.getStatus().equals("SCHEDULED") || currentFixture.getStatus().equals("TIMED") ||
                currentFixture.getStatus().equals("POSTPONED")) {
            displayableItem.setFixtureStatusBackgroundColor(ContextCompat.getColor(context, R.color.gray));
            displayableItem.setFixtureStatusText(DateFormatterFactory.formatDateForFixture(currentFixture.getDate()));
        } else {
            displayableItem.setFixtureStatusBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            displayableItem.setFixtureStatusText(currentFixture.getResult().getGoalsHomeTeam() + " - " +
                    currentFixture.getResult().getGoalsAwayTeam());
        }
        return displayableItem;
    }
}
