
package com.example.android.roomwordssample

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TodoListAdapter internal constructor(
        private val context: Context
) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var todos = emptyList<Todo>() // Cached copy of words

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleItemView: TextView = itemView.findViewById(R.id.textView_title)
        val dateItemView: TextView = itemView.findViewById(R.id.textView_date)
        val containView: LinearLayout = itemView.findViewById(R.id.ll_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return TodoViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val current = todos[position]
        holder.titleItemView.text = current.title
        holder.dateItemView.text = current.date
        holder.containView.setOnClickListener {
            val intent = Intent(context, ContentActivity::class.java).apply {
                putExtra(EXTRA_TITLE,holder.titleItemView.text.toString())
                putExtra(EXTRA_CONTENT,current.content)
                Log.d("!!!",holder.titleItemView.text.toString())
            }
            holder.containView.context.startActivity(intent)
        }
    }

    internal fun setWords(todos: List<Todo>) {
        this.todos = todos
        notifyDataSetChanged()
    }
    override fun getItemCount() = todos.size

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_CONTENT = "content"
        const val EXTRA_DATE = "date"
    }
}
