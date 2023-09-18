
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.greenwizard.data.dumpreports
import com.example.greenwizard.data.recyclepoint
import com.example.greenwizard.data.reportRepository
import com.example.madassignmentproject.data.reportDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class reportViewModel (application: Application): AndroidViewModel(application){

    private val readAllData: LiveData<List<dumpreports>>
    private val readAllRecycleData: LiveData<List<recyclepoint>>
    private val repository: reportRepository

    init {
        val reportDao = reportDatabase.getDatabase(application).reportDao()
        repository = reportRepository(reportDao)
        readAllData = repository.readAllData
        readAllRecycleData = repository.readAllRecycleData
    }

    fun addReport(dumpreports: dumpreports){
        viewModelScope.launch(Dispatchers.IO){
            repository.addReport(dumpreports)
        }
    }

    fun listReports(): LiveData<List<dumpreports>> {
        return readAllData
    }

    fun addRecycle(recyclepoint: recyclepoint){
        viewModelScope.launch(Dispatchers.IO){
            repository.addRecycle(recyclepoint)
        }
    }

    fun listRecycle(): LiveData<List<recyclepoint>> {
        return readAllRecycleData
    }

}