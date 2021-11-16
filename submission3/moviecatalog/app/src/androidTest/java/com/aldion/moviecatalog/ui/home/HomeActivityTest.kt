package com.aldion.moviecatalog.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.utils.DataDummy
import com.aldion.moviecatalog.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private val dummyMovie = DataDummy.generateDummyFilms()
    private val dummyTvShows = DataDummy.generateDummyTvShows()

    @Before
    fun setUp() {
        ActivityScenario.launch(HomeActivity::class.java)
        IdlingRegistry.getInstance().register(EspressoIdlingResource.idlingResource)
    }

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
        onView(withId(R.id.tv_year)).check(matches(withText(dummyMovie[0].releaseDate)))
        onView(withId(R.id.tv_user_review)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(withText(dummyMovie[0].voteAverage.toString())))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(withText(dummyMovie[0].overview)))
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
        onView(withId(R.id.tv_year)).check(matches(withText(dummyTvShows[0].releaseDate)))
        onView(withId(R.id.tv_user_review)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_user_review_number)).check(matches(withText(dummyTvShows[0].voteAverage.toString())))
        onView(withId(R.id.tv_description)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_description_content)).check(matches(withText(dummyTvShows[0].overview)))
    }

    @After
    fun tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.idlingResource)
    }
}