package eu.de.servicetestfragment.ui.main

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat
import androidx.lifecycle.Observer
import eu.de.servicetestfragment.R
import eu.de.servicetestfragment.ui.main.other.Constants.Action_Start_Or_Resume_Service
import eu.de.servicetestfragment.ui.main.services.TestService
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.testS.observe(this, testDataObserver)
        //viewModel.loading.observe(this, loadingLiveDataObserver)
        //viewModel.loadError.observe(this, errorLiveDataObserver)
        viewModel.testS.value = "Q_"//    refresh()
    }




    //--------
    /*
    private val animalListDataObserver = Observer<List<Animal>> {list ->
        list?.let {
            animalList.visibility = View.VISIBLE
            listAdapter.updateAnimalList(it)
        }
    }*/

    private val testDataObserver = Observer<String> {test ->
       //test?.also{
       test?.let{

            if( test == "Q_A"){
                println("ZUTREFFEND!!")
            }

           // 1) TESTS MIT LET UND ANDEREN !!!
           // 2) Room integrieren
            // 3) tests integrieren -- injection !!

            // gdfgjfg jdkgj sljdg jg
           // viewModel.testS.value = if( test == "Q_A") "lala" else "_ELSE"

        }
    }

    //---------


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
button.setOnClickListener{
    viewModel.refresh()
    sendCommandToService(Action_Start_Or_Resume_Service)//,viewModel.testS.value)
}

    }


    private fun sendCommandToService(action:String)=//,testST2:String?) =

    Intent(requireContext(), TestService::class.java).also{
                it.action = action
        it.putExtra("Name", "ccc")
        //it.dataString = "test"
        //it.
        //it.testSt1 = testST2
                // wont start service  --> but instead delivers intent to service!!
                requireContext().startService(it)
            }

}
