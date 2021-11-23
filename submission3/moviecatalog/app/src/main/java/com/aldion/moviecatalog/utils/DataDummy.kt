package com.aldion.moviecatalog.utils

import com.aldion.moviecatalog.data.source.local.entity.ShowEntity
import com.aldion.moviecatalog.data.source.remote.response.MovieResponse
import com.aldion.moviecatalog.data.source.remote.response.TvResponse

object DataDummy {

    fun generateDummyFilms(): List<ShowEntity> {
        val films = ArrayList<ShowEntity>()

        films.add(ShowEntity(
            566525,
            "Shang-Chi and the Legend of the Ten Rings",
            "Movie",
            "2021-09-01",
            7.9,
            "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
            false, "/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"
        ))

        films.add(ShowEntity(
            580489,
            "Venom: Let There Be Carnage",
            "Movie",
            "2021-09-30",
            6.8,
            "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            false, "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
        ))

        films.add(ShowEntity(
            524434,
            "Eternals",
            "Movie",
            "2021-11-03",
            7.1,
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            false, "/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"
        ))

        films.add(ShowEntity(
            796499,
            "Army of Thieves",
            "Movie",
            "2021-10-27",
            6.9,
            "A mysterious woman recruits bank teller Ludwig Dieter to lead a group of aspiring thieves on a top-secret heist during the early stages of the zombie apocalypse.",
            false, "/5YCg0PFnGxDKb24Lmhxz8p4Q8j1.jpg"
        ))

        films.add(ShowEntity(
            370172,
            "No Time to Die",
            "Movie",
            "2021-09-29",
            7.5,
            "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
            false, "/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg"
        ))

        films.add(ShowEntity(
            522402,
            "Finch",
            "Movie",
            "2021-11-04",
            8.1,
            "On a post-apocalyptic Earth, a robot, built to protect the life of his dying creator's beloved dog, learns about life, love, friendship, and what it means to be human.",
            false, "/jKuDyqx7jrjiR9cDzB5pxzhJAdv.jpg"
        ))

        films.add(ShowEntity(
            744275,
            "After We Fell",
            "Movie",
            "2021-09-01",
            7.3,
            "Just as Tessa's life begins to become unglued, nothing is what she thought it would be. Not her friends nor her family. The only person that she should be able to rely on is Hardin, who is furious when he discovers the massive secret that she's been keeping. Before Tessa makes the biggest decision of her life, everything changes because of revelations about her family.",
            false, "/suN9WacmM6TIUOuYonHc1iL7uRw.jpg"
        ))

        films.add(ShowEntity(
            550988,
            "Free Guy",
            "Movie",
            "2021-08-11",
            7.8,
            "A bank teller called Guy realizes he is a background character in an open world video game called Free City that will soon go offline.",
            false, "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
        ))

        films.add(ShowEntity(
            763164,
            "Apex",
            "Movie",
            "2021-11-12",
            5.8,
            "Ex-cop James Malone is serving a life sentence for a crime he didn’t commit. He is offered a chance at freedom if he can survive a deadly game of Apex, in which six hunters pay for the pleasure of hunting another human on a remote island. He accepts, and once he arrives, all hell breaks loose.",
            false, "/cobRV6hAj8h7dRU4WZ3dkGaRQv2.jpg"
        ))

        films.add(ShowEntity(
            843241,
            "The Seven Deadly Sins: Cursed by Light",
            "Movie",
            "2021-07-02",
            8.2,
            "With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
            false,
            "/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg"
        ))

        return films
    }

    fun generateDummyTvShows(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()

        shows.add(ShowEntity(
            93405,
            "Squid Game",
            "tv",
            "2021-09-17",
            7.8,
            "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor.",
            false, "/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg"
        ))

        shows.add(ShowEntity(
            113901,
            "Maradona: Blessed Dream", "tv",
            "2021-10-29",
            7.7,
            "The controversial life and history of Argentine football legend Diego Armando Maradona. From his beginnings in Villa Fiorito, one of the poorest barrios of Buenos Aires, to achieving glory on the international football league. Earning himself a well-deserved place in history. Living a life strewn with drugs, sex and public scrutiny, he played by his own rules regardless of the consequences. Watch the man who took the world by storm and made his way into the hearts of millions.",
            false, "/mGPdWEEmfzP7VQBQsXrFt1b1ikQ.jpg"
        ))

        shows.add(ShowEntity(
            94605,
            "Arcane", "tv",
            "2021-11-06",
            9.3,
            "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and clashing convictions.",
            false, "/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg"
        ))

        shows.add(ShowEntity(
            2051,
            "The Price Is Right", "tv",
            "1972-09-04",
            6.9,
            "\"Come on down!\" The Price Is Right features a wide variety of games and contests with the same basic challenge: Guess the prices of everyday (or not-quite-everyday) retail items. ",
            false, "/6m4uYFAJwkanZXd0n0HUQ0lYHLl.jpg",
        ))

        shows.add(ShowEntity(
            1991,
            "Rachael Ray", "tv",
            "2006-09-18",
            5.3,
            "Rachael Ray, also known as The Rachael Ray Show, is an American talk show starring Rachael Ray that debuted in syndication in the United States and Canada on September 18, 2006. It is filmed at Chelsea Television Studios in New York City. The show's 8th season premiered on September 9, 2013, and became the last Harpo show in syndication to switch to HD with a revamped studio. In January 2012, CBS Television Distribution announced a two-year renewal for the show, taking it through the 2013–14 season.",
            false, "/dsAJhCLYX1fiNRoiiJqR6Up4aJ.jpg",
        ))

        shows.add(ShowEntity(
            2778,
            "Wheel of Fortune", "tv",
            "1983-09-19",
            7.2,
            "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
            false, "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg"
        ))

        shows.add(ShowEntity(
            127235,
            "Invasion", "tv",
            "2021-10-21",
            7.5,
            "Earth is visited by an alien species that threatens humanity’s existence. Events unfold in real time through the eyes of five ordinary people across the globe as they struggle to make sense of the chaos unraveling around them.",
            false, "/7rpiHZx10Nm50AtzTUEO9eyaKdq.jpg"
        ))

        shows.add(ShowEntity(
            63174,
            "Lucifer", "tv",
            "2016-01-25",
            8.5,
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            false, "/ekZobS8isE6mA53RAiGDG93hBxL.jpg"
        ))

        shows.add(ShowEntity(
            84299,
            "Al Hayba", "tv",
            "2017-05-27",
            6.3,
            "In a village by the Lebanon-Syria border, the head of an arms-smuggling clan contends with family conflicts, power struggles and complicated love.",
            false, "/3QTp0Vu3t3ZfHwMvOOLpCUkJHZN.jpg"
        ))

        shows.add(ShowEntity(
            71712,
            "The Good Doctor", "tv",
            "2017-09-25",
            8.6,
            "Shaun Murphy, a young surgeon with autism and savant syndrome, relocates from a quiet country life to join a prestigious hospital's surgical unit. Unable to personally connect with those around him, Shaun uses his extraordinary medical gifts to save lives and challenge the skepticism of his colleagues.",
            false, "/cXUqtadGsIcZDWUTrfnbDjAy8eN.jpg"
        ))

        return shows
    }

    fun generateRemoteDummyFilms(): List<MovieResponse> {
        val films = ArrayList<MovieResponse>()

        films.add(MovieResponse(
            566525,
            "Shang-Chi and the Legend of the Ten Rings",
            "2021-09-01",
            7.9,
            "Shang-Chi must confront the past he thought he left behind when he is drawn into the web of the mysterious Ten Rings organization.",
            "/1BIoJGKbXjdFDAqUEiA2VHqkK1Z.jpg"
        ))

        films.add(MovieResponse(
            580489,
            "Venom: Let There Be Carnage",
            "2021-09-30",
            6.8,
            "After finding a host body in investigative reporter Eddie Brock, the alien symbiote must face a new enemy, Carnage, the alter ego of serial killer Cletus Kasady.",
            "/rjkmN1dniUHVYAtwuV3Tji7FsDO.jpg"
        ))

        films.add(MovieResponse(
            524434,
            "Eternals",
            "2021-11-03",
            7.1,
            "The Eternals are a team of ancient aliens who have been living on Earth in secret for thousands of years. When an unexpected tragedy forces them out of the shadows, they are forced to reunite against mankind’s most ancient enemy, the Deviants.",
            "/6AdXwFTRTAzggD2QUTt5B7JFGKL.jpg"
        ))

        films.add(MovieResponse(
            796499,
            "Army of Thieves",
            "2021-10-27",
            6.9,
            "A mysterious woman recruits bank teller Ludwig Dieter to lead a group of aspiring thieves on a top-secret heist during the early stages of the zombie apocalypse.",
            "/5YCg0PFnGxDKb24Lmhxz8p4Q8j1.jpg"
        ))

        films.add(MovieResponse(
            370172,
            "No Time to Die",
            "2021-09-29",
            7.5,
            "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.",
            "/iUgygt3fscRoKWCV1d0C7FbM9TP.jpg"
        ))

        films.add(MovieResponse(
            522402,
            "Finch",
            "2021-11-04",
            8.1,
            "On a post-apocalyptic Earth, a robot, built to protect the life of his dying creator's beloved dog, learns about life, love, friendship, and what it means to be human.",
            "/jKuDyqx7jrjiR9cDzB5pxzhJAdv.jpg"
        ))

        films.add(MovieResponse(
            744275,
            "After We Fell",
            "2021-09-01",
            7.3,
            "Just as Tessa's life begins to become unglued, nothing is what she thought it would be. Not her friends nor her family. The only person that she should be able to rely on is Hardin, who is furious when he discovers the massive secret that she's been keeping. Before Tessa makes the biggest decision of her life, everything changes because of revelations about her family.",
            "/suN9WacmM6TIUOuYonHc1iL7uRw.jpg"
        ))

        films.add(MovieResponse(
            550988,
            "Free Guy",
            "2021-08-11",
            7.8,
            "A bank teller called Guy realizes he is a background character in an open world video game called Free City that will soon go offline.",
            "/xmbU4JTUm8rsdtn7Y3Fcm30GpeT.jpg",
        ))

        films.add(MovieResponse(
            763164,
            "Apex",
            "2021-11-12",
            5.8,
            "Ex-cop James Malone is serving a life sentence for a crime he didn’t commit. He is offered a chance at freedom if he can survive a deadly game of Apex, in which six hunters pay for the pleasure of hunting another human on a remote island. He accepts, and once he arrives, all hell breaks loose.",
            "/cobRV6hAj8h7dRU4WZ3dkGaRQv2.jpg"
        ))

        films.add(MovieResponse(
            843241,
            "The Seven Deadly Sins: Cursed by Light",
            "2021-07-02",
            8.2,
            "With the help of the \"Dragon Sin of Wrath\" Meliodas and the worst rebels in history, the Seven Deadly Sins, the \"Holy War\", in which four races, including Humans, Goddesses, Fairies and Giants fought against the Demons, is finally over. At the cost of the \"Lion Sin of Pride\" Escanor's life, the Demon King was defeated and the world regained peace. After that, each of the Sins take their own path.",
            "/k0ThmZQl5nHe4JefC2bXjqtgYp0.jpg"
        ))

        return films
    }

    fun generateRemoteDummyTvShows(): List<TvResponse> {
        val shows = ArrayList<TvResponse>()

        shows.add(TvResponse(
            93405,
            "Squid Game",
            "2021-09-17",
            7.8,
            "Hundreds of cash-strapped players accept a strange invitation to compete in children's games—with high stakes. But, a tempting prize awaits the victor.",
            "/dDlEmu3EZ0Pgg93K2SVNLCjCSvE.jpg"
        ))

        shows.add(TvResponse(
            113901,
            "Maradona: Blessed Dream",
            "2021-10-29",
            7.7,
            "The controversial life and history of Argentine football legend Diego Armando Maradona. From his beginnings in Villa Fiorito, one of the poorest barrios of Buenos Aires, to achieving glory on the international football league. Earning himself a well-deserved place in history. Living a life strewn with drugs, sex and public scrutiny, he played by his own rules regardless of the consequences. Watch the man who took the world by storm and made his way into the hearts of millions.",
            "/mGPdWEEmfzP7VQBQsXrFt1b1ikQ.jpg"
        ))

        shows.add(TvResponse(
            94605,
            "Arcane",
            "2021-11-06",
            9.3,
            "Amid the stark discord of twin cities Piltover and Zaun, two sisters fight on rival sides of a war between magic technologies and clashing convictions.",
            "/fqldf2t8ztc9aiwn3k6mlX3tvRT.jpg"
        ))

        shows.add(TvResponse(
            2051,
            "The Price Is Right",
            "1972-09-04",
            6.9,
            "\"Come on down!\" The Price Is Right features a wide variety of games and contests with the same basic challenge: Guess the prices of everyday (or not-quite-everyday) retail items. ",
            "/6m4uYFAJwkanZXd0n0HUQ0lYHLl.jpg",
        ))

        shows.add(TvResponse(
            1991,
            "Rachael Ray",
            "2006-09-18",
            5.3,
            "Rachael Ray, also known as The Rachael Ray Show, is an American talk show starring Rachael Ray that debuted in syndication in the United States and Canada on September 18, 2006. It is filmed at Chelsea Television Studios in New York City. The show's 8th season premiered on September 9, 2013, and became the last Harpo show in syndication to switch to HD with a revamped studio. In January 2012, CBS Television Distribution announced a two-year renewal for the show, taking it through the 2013–14 season.",
            "/dsAJhCLYX1fiNRoiiJqR6Up4aJ.jpg",
        ))

        shows.add(TvResponse(
            2778,
            "Wheel of Fortune",
            "1983-09-19",
            7.2,
            "This game show sees contestants solve word puzzles, similar to those used in Hangman, to win cash and prizes determined by spinning a giant carnival wheel.",
            "/2fvAIyVfFHQdhJ7OsJWuMlF7836.jpg"
        ))

        shows.add(TvResponse(
            127235,
            "Invasion",
            "2021-10-21",
            7.5,
            "Earth is visited by an alien species that threatens humanity’s existence. Events unfold in real time through the eyes of five ordinary people across the globe as they struggle to make sense of the chaos unraveling around them.",
            "/7rpiHZx10Nm50AtzTUEO9eyaKdq.jpg"
        ))

        shows.add(TvResponse(
            63174,
            "Lucifer",
            "2016-01-25",
            8.5,
            "Bored and unhappy as the Lord of Hell, Lucifer Morningstar abandoned his throne and retired to Los Angeles, where he has teamed up with LAPD detective Chloe Decker to take down criminals. But the longer he's away from the underworld, the greater the threat that the worst of humanity could escape.",
            "/ekZobS8isE6mA53RAiGDG93hBxL.jpg"
        ))

        shows.add(TvResponse(
            84299,
            "Al Hayba",
            "2017-05-27",
            6.3,
            "In a village by the Lebanon-Syria border, the head of an arms-smuggling clan contends with family conflicts, power struggles and complicated love.",
            "/3QTp0Vu3t3ZfHwMvOOLpCUkJHZN.jpg"
        ))

        shows.add(TvResponse(
            71712,
            "The Good Doctor",
            "2017-09-25",
            8.6,
            "Shaun Murphy, a young surgeon with autism and savant syndrome, relocates from a quiet country life to join a prestigious hospital's surgical unit. Unable to personally connect with those around him, Shaun uses his extraordinary medical gifts to save lives and challenge the skepticism of his colleagues.",
            "/cXUqtadGsIcZDWUTrfnbDjAy8eN.jpg"
        ))

        return shows
    }

  //  fun generateRemoteDummyMovie(movieId:Int):MovieResponse = MovieResponse(movieId,"This is dummy film")
  //  fun generateDummyMovie(movieId:Int):ShowEntity = ShowEntity(555)
}
