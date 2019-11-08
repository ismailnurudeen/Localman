package xyz.ismailnurudeen.originexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import xyz.ismailnurudeen.origin.Origin
import xyz.ismailnurudeen.origin.Origin.Companion.States

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val origin = Origin(this)

        Log.d("origin-lib", "All LGAs: ${origin.getAllLGAs()}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("origin-lib", "All States: ${origin.getAllStates()}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("origin-lib", "All LGAs in EDO: ${origin.getLGAs(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "All Cities in EDO: ${origin.getCities(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("origin-lib", "Capital of EDO State: ${origin.getCapital(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )

        Log.d("origin-lib", "State of Ikot Ekpene LGA: ${origin.getLGAState("Ikot Ekpene")}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "State of Auchi city: ${origin.getCityState("auchi")}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Latitude of EDO State: ${origin.getLatitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Maximum Latitude of EDO State: ${origin.getMaxLatitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Minimum Latitude of EDO State: ${origin.getMinLatitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Longitude of EDO State: ${origin.getLongitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Maximum Longitude of EDO State: ${origin.getMaxLongitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
        Log.d("origin-lib", "Minimum Longitude of EDO State: ${origin.getMinLongitude(States.EDO)}")
        Log.d(
            "origin-lib",
            "____________________________________________________________________________________\n" +
                    "\n"
        )
    }
}
