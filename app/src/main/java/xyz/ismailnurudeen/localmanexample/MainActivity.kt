package xyz.ismailnurudeen.localmanexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import xyz.ismailnurudeen.localman.Localman
import xyz.ismailnurudeen.localman.Localman.Companion.States

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val localman = Localman(this)

        Log.d("localman-lib", "All LGAs: ${localman.getAllLGAs()}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("localman-lib", "All States: ${localman.getAllStates()}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("localman-lib", "All LGAs in EDO: ${localman.getLGAs(States.EDO)}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("localman-lib", "All Cities in EDO: ${localman.getCities(States.EDO)}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("localman-lib", "Capital of EDO State: ${localman.getCapital(States.EDO)}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("localman-lib", "State of Ikot Ekpene LGA: ${localman.getLGAState("Ikot Ekpene")}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("localman-lib", "State of Auchi city: ${localman.getCityState("auchi")}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("localman-lib", "Latitude of EDO State: ${localman.getLatitude(States.EDO)}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d(
            "localman-lib",
            "Maximum Latitude of EDO State: ${localman.getMaxLatitude(States.EDO)}"
        )
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d(
            "localman-lib",
            "Minimum Latitude of EDO State: ${localman.getMinLatitude(States.EDO)}"
        )
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("localman-lib", "Longitude of EDO State: ${localman.getLongitude(States.EDO)}")
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d(
            "localman-lib",
            "Maximum Longitude of EDO State: ${localman.getMaxLongitude(States.EDO)}"
        )
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d(
            "localman-lib",
            "Minimum Longitude of EDO State: ${localman.getMinLongitude(States.EDO)}"
        )
        Log.d(
            "localman-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
    }
}
