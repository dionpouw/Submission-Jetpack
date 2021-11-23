package com.aldion.movieshowsapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.aldion.movieshowsapp.ui.home.HomeActivity
import com.aldion.movieshowsapp.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyFilms()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movies_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(withText(dummyMovie[0].year)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.tv_user_review)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(withText(dummyMovie[0].userRating)))
        onView(withId(R.id.tv_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_list_actor)).check(matches(withText(dummyMovie[0].actor)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(withText(dummyMovie[0].description)))
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_movies_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies_shows)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovie.size
            )
        )
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_movies_shows)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(matches(withText(dummyTvShows[0].title)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_year)).check(matches(withText(dummyTvShows[0].year)))
        onView(withId(R.id.tv_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShows[0].genre)))
        onView(withId(R.id.tv_user_review)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(withText(dummyTvShows[0].userRating)))
        onView(withId(R.id.tv_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_list_actor)).check(matches(withText(dummyTvShows[0].actor)))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(withText(dummyTvShows[0].description)))
    }
}