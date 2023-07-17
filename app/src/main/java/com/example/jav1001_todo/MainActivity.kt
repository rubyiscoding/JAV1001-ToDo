package com.example.jav1001_todo
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView


class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var addButton: Button
    private lateinit var listView: ListView
    private lateinit var items: MutableList<String>
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        editText = findViewById(R.id.editText)
        addButton = findViewById(R.id.addButton)
        listView = findViewById(R.id.listView)

        items = mutableListOf()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_checked, items)
        listView.adapter = adapter

        // Add button click listener
        addButton.setOnClickListener {
            val newItem = editText.text.toString().trim()
            if (newItem.isNotEmpty()) {
                items.add(newItem)
                adapter.notifyDataSetChanged()
                editText.text.clear() // Clear the EditText after adding an item
                editText.clearFocus() // Remove focus from the EditText
            }
        }


    }
}
