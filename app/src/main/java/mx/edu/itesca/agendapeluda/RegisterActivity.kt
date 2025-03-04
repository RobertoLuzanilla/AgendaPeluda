package mx.edu.itesca.agendapeluda

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val buttonRegistrarse: Button = findViewById(R.id.btnRegistrarse)

        buttonRegistrarse.setOnClickListener {
            val intent: Intent = Intent(
                this, login::class.java
            )
            startActivity(intent)
        }

        val buttonRegresar: Button = findViewById(R.id.btnRegresar)

        buttonRegresar.setOnClickListener {
            val intent: Intent = Intent(
                this, MainActivity::class.java
            )
            startActivity(intent)
        }
    }
}