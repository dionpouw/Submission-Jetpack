package com.aldion.moviecatalog.utils

import com.aldion.moviecatalog.R
import com.aldion.moviecatalog.data.ShowEntity

object DataDummy {

    fun generateDummyFilms(): List<ShowEntity> {
        val films = ArrayList<ShowEntity>()

        films.add(
            ShowEntity(
                "Movie1",
                "Movie",
                "A Star Is Born",
                "2018",
                "Drama, Romance, Music",
                "Bradley Cooper, Lady Gaga, Sam Elliot, Andrew Dice Clay, Rafi Gavron, Anthony Ramos",
                "75%",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                R.drawable.poster_a_start_is_born
            )
        )

        films.add(
            ShowEntity(
                "Movie2", "Movie",
                "Alita: Battle Angel",
                "2019",
                "Action, Science Fiction, Adventure",
                "Rosa Salazar, Christoph Waltz, Jennifer Connelly, Mahershala Ali, Ed Skrein, Jackie Earle Haley",
                "72%",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                R.drawable.poster_alita
            )
        )

        films.add(
            ShowEntity(
                "Movie3", "Movie",
                "Aquaman",
                "2018",
                "Action, Adventure, Fantasy",
                "Jason Momoa, Amber Heard, Willem Dafoe, Patrick Wilson, Nicole Kidman, Dolph Lundgren, Yahya Abdul-Mateen II",
                "69%",
                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
                R.drawable.poster_aquaman
            )
        )

        films.add(
            ShowEntity(
                "Movie4", "Movie",
                "Bohemian Rhapsody",
                "2018",
                "Music, Drama, History",
                "Rami Malek, Gwilym Lee, Ben Hardy, Joseph Mazzello, Lucy Boynton, Aidan Gillen, Allen Leech, Tom Hollander",
                "80%",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                R.drawable.poster_bohemian
            )
        )
        films.add(
            ShowEntity(
                "Movie5", "Movie",
                "Creed II",
                "2018",
                "Drama",
                "Michael B. Jordan, Sylvester Stallone, Dolph Lundgren, Florian Munteanu, Tessa Thompson, Wood Harris, Phylicia Rashād",
                "69%",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                R.drawable.poster_creed
            )
        )
        films.add(
            ShowEntity(
                "Movie6", "Movie",
                "How to Train Your Dragon: The Hidden World",
                "2019",
                "Animation, Family, Adventure",
                "Jay Baruchel, America Ferrera, F. Murray Abraham, Cate Blanchett, Gerrad Butler, Craig Ferguson, Jonah Hill",
                "78%",
                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
                R.drawable.poster_how_to_train
            )
        )

        films.add(
            ShowEntity(
                "Movie7", "Movie",
                "Avengers: Infinity War",
                "2018",
                "Adventure, Action, Science Fiction",
                "Robert Downey Jr., Chris Hemsworth, Mark Ruffalo, Chris Evans, Scarlett Johansson, Benedict Cumberbatch, Tom Holland, Chadwick Boseman ",
                "83%",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                R.drawable.poster_infinity_war
            )
        )

        films.add(
            ShowEntity(
                "Movie8", "Movie",
                "Cold Pursuit",
                "2019",
                "Action, Crime, Thriller",
                "Liam Neeson, Laura Dern, Emmy Rossum, Michael Eklund,Micheál Richardson,Bradley Stryker, Tom Bateman",
                "57%",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                R.drawable.poster_cold_persuit
            )
        )

        films.add(
            ShowEntity(
                "Movie9", "Movie",
                "T-34",
                "2018",
                "War, Action, Drama, History",
                "Alexander Petrov, Victor Dobronravov, Irina Starshenbaum, Vinzenz Kiefer, Petr Skvortsov, Semyon Treskunov",
                "70%",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                R.drawable.poster_t34
            )
        )

        films.add(
            ShowEntity(
                "Movie10", "Movie",
                "Spider-Man: Into the Spider-Verse",
                "2018",
                "Action, Adventure, Animation, Sci-Fi, Comedy",
                "Shameik Moore, Jake Johnson, Hailee Steinfeld, Mahershala Ali, Brian Tyree Henry, Lily Tomlin, Lauren Vélez",
                "84%",
                "Miles Morales is juggling his life between being a high school student and being a spider-man. When Wilson \"Kingpin\" Fisk uses a super collider, others from across the Spider-Verse are transported to this dimension.",
                R.drawable.poster_spiderman
            )
        )
        return films
    }

    fun generateDummyTvShows(): List<ShowEntity> {
        val shows = ArrayList<ShowEntity>()

        shows.add(
            ShowEntity(
                "Tv1", "Shows",
                "Arrow",
                "2012",
                "Crime, Drama, Mystery, Action & Adventure",
                "Stephen Amell, David Ramsey, Emily Bett, Katie Cassidy, Paul Blackthorne, Willa Holland, Rick Gonzalez",
                "67%",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                R.drawable.poster_arrow
            )
        )

        shows.add(
            ShowEntity(
                "Tv2", "Shows",
                "Dragon Ball",
                "1986",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Masako Nozawa, Mayumi Tanaka, Hiromi Tsuru, Toru Furuya, Naoki Tatsuta, Naoko Watanabe, Mami Koyama",
                "82%",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                R.drawable.poster_dragon_ball
            )
        )

        shows.add(
            ShowEntity(
                "Tv3", "Shows",
                "Fairy Tail",
                "2009",
                "Action & Adventure, Animation, Comedy, Sci-Fi & Fantasy, Mystery",
                "Yoshimitsu Shimoyama, Eiji Miyashita, Fuyuka Ono, Daisuke Namikawa, Masafumi Kimura,Eri Kitamura",
                "78%",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                R.drawable.poster_fairytail
            )
        )

        shows.add(
            ShowEntity(
                "Tv4", "Shows",
                "Family Guy",
                "1999",
                "Animation, Comedy",
                "Seth MacFarlane, Alex Borstein, Seth Green, Mila Kunis, Mike Henry, Patrick Warbuton, Adam West, Kevin Michael",
                "71%",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                R.drawable.poster_family_guy
            )
        )
        shows.add(
            ShowEntity(
                "Tv5", "Shows",
                "The Flash",
                "2014",
                "Drama, Sci-Fi & Fantasy",
                "Grant Gustin, Candice Patton, Danielle Panabaker, Jesse L. Martin, Carlos Valdes, Tom Cavanagh, Danielle Nicolet",
                "78%",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                R.drawable.poster_flash

            )
        )

        shows.add(
            ShowEntity(
                "Tv6", "Shows",
                "Game of Thrones",
                "2011",
                "Sci-Fi & Fantasy, Drama, Action & Adventure",
                "Nikolaj Coster-Waldau, Lena Headey, Emilia Clarke, Kit Harington, Sophie Turner, Maisie Williams, Rory McCann, Peter Dinklage",
                "84%",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.poster_god
            )
        )

        shows.add(
            ShowEntity(
                "Tv7", "Shows",
                "Marvel's Iron Fist",
                "2017",
                "Action & Adventure, Drama, Sci-Fi & Fantasy",
                "Finn Jones, Jessica Henwick, Jessica Stroup, Tom Pelphrey, Sacha Dhawan, Rosario Dawson, David Wenham, Alice Eve, Wai Ching Ho",
                "66%",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                R.drawable.poster_iron_fist
            )
        )

        shows.add(
            ShowEntity(
                "Tv8", "Shows",
                "Naruto Shippūden",
                "2007",
                "Animation, Action & Adventure, Sci-Fi & Fantasy",
                "Jouji Nakata, Junko Takeuchi, Chie Nakamura, Noriaki Sugiyama, Kazuhiko Inoue, Satoshi Hino, Akira Ishida, Hideo Ishikawa, Kōichi Tōchika",
                "86%",
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                R.drawable.poster_naruto_shipudden
            )
        )

        shows.add(
            ShowEntity(
                "Tv9", "Shows",
                "Supergirl",
                "2015",
                "Drama, Sci-Fi & Fantasy, Action & Adventure",
                "David Harewood, Melissa Benoist, Chyler Leigh, Katie McGrath, Mehcad Brooks, Jeremy Jordan, Jesse Rath, Nicole Maines, Chris Wood",
                "73%",
                "Twenty-four-year-old Kara Zor-El, who was taken in by the Danvers family when she was 13 after being sent away from Krypton, must learn to embrace her powers after previously hiding them. The Danvers teach her to be careful with her powers, until she has to reveal them during an unexpected disaster, setting her on her journey of heroism.",
                R.drawable.poster_supergirl
            )
        )

        shows.add(
            ShowEntity(
                "Tv10", "Shows",
                "Supernatural",
                "2005",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "Jared Padalecki, Jensen Ackles, Misha Collins, Mark Sheppard, Alexander Calvert, Jim Beaver, Mark Pellegrino, Ruth Connell, Samantha Smith",
                "73%",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                R.drawable.poster_supernatural
            )
        )
        return shows
    }
}