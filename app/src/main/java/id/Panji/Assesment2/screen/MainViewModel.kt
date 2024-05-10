package id.Panji.Assesment2.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.Panji.Assesment2.database.NominalDao
import id.Panji.Assesment2.model.Nominal
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(private val dao: NominalDao) : ViewModel() {

    fun sortedData(ascending: Boolean): StateFlow<List<Nominal>> {
        return if (ascending) {
            dao.getNominalSortedByDateAscending().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = emptyList()
            )
        } else {
            dao.getNominalSortedByDateDescending().stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000L),
                initialValue = emptyList()
            )
        }
    }
}
