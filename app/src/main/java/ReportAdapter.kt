import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.greenwizard.data.dumpreports
import com.example.madassignmentproject.R

class ReportAdapter : RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {
    private var reports: List<dumpreports> = emptyList()

    fun setData(reports: List<dumpreports>) {
        this.reports = reports
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_report__list, parent, false)
        return ReportViewHolder(view)
    }

    override fun getItemCount(): Int = reports.size

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {
        val report = reports[position]
        // Bind data to views in the ViewHolder
        holder.bind(report)
    }

    inner class ReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Define views in the item layout and bind data to them
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val datetimeTextView: TextView = itemView.findViewById(R.id.datetimeTextView)
        private val typeofwasteTextView: TextView = itemView.findViewById(R.id.typeofwasteTextView)

        fun bind(report: dumpreports) {
            // Set data to views
            addressTextView.text = report.address
            datetimeTextView.text = report.datetime
            typeofwasteTextView.text = report.typeofwaste
        }
    }
}
