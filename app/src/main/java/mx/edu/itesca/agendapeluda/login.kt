package mx.edu.itesca.agendapeluda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val buttonLogin: Button = findViewById(R.id.btnLogin)

        buttonLogin.setOnClickListener {
            val intent: Intent = Intent(
                this, CalendarActivity::class.java
            )
            startActivity(intent)
        }

        val buttonRegister: Button = findViewById(R.id.btnRegister)

        buttonRegister.setOnClickListener {
            val intent: Intent = Intent(
                this, RegisterActivity::class.java
            )
            startActivity(intent)
        }
    }
}