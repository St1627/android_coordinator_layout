import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.example.common.databinding.RecyclerviewItemLayoutBinding

class TestVH(binding: RecyclerviewItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    val text = binding.text
}

class TestAdapter(private val biggerPadding: Boolean) : RecyclerView.Adapter<TestVH>() {

    private var list: MutableList<String> = ArrayList()

    fun setData(values: List<String>) {
        if (values.isNotEmpty()) {
            notifyItemRangeRemoved(0, list.size - 1)
            list.clear()
            list.addAll(values)
            notifyItemRangeInserted(0, list.size - 1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestVH {
        val binding = RecyclerviewItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TestVH(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TestVH, position: Int) {
        holder.text.text = list[position]
        if (biggerPadding) {
            holder.text.setPadding(Math.round(20 * holder.itemView.context.resources.displayMetrics.density))
        }
    }

}