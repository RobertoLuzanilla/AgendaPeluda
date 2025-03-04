package mx.edu.itesca.agendapeluda

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CalendarView
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class CalendarActivity : AppCompatActivity() {
    private lateinit var adapter: ArrayAdapter<String>
    private val activities = mutableListOf<String>()
    private lateinit var listView: ListView
    private lateinit var calendarView: CalendarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calendar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonActividad: Button = findViewById(R.id.addButton)

        buttonActividad.setOnClickListener {
            val intent: Intent = Intent(
                this, activity_add_event::class.java
            )
            startActivity(intent)
        }

        listView = findViewById(R.id.listView)
        calendarView = findViewById(R.id.calendarView)

        adapter = ArrayAdapter(this, R.layout.activity_calendar_item, R.id.petName, activities)
        listView.adapter = adapter

        // Default al entrar

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        loadActivitiesForDate(year, month, dayOfMonth)

        // Cuando seleccionas un día

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            loadActivitiesForDate(year, month, dayOfMonth)
        }
    }

    private fun loadActivitiesForDate(year: Int, month: Int, dayOfMonth: Int) {
        activities.clear()
        activities.addAll(getActivitiesForDate(year, month, dayOfMonth))
        adapter.notifyDataSetChanged()
    }

    private fun getActivitiesForDate(year: Int, month: Int, dayOfMonth: Int): List<String> {
        return listOf(
            "Quevedo - Clase de Cisco",
            "Firulais - Paseo matutino",
            "Michi - Comida",
            "Firulais - Paseo vespertino",
            "Angulo - Regar la plantita",
            "Quevedo - Jugar consigo mismo"
        )
    }
}