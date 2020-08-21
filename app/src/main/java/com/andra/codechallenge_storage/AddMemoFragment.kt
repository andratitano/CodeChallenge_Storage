package com.andra.codechallenge_storage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.andra.codechallenge_storage.database.DatabaseMemo
import com.andra.codechallenge_storage.database.Memo
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_add_memo.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddMemoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddMemoFragment : DialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var db: DatabaseMemo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_memo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        this.context?.let { it ->
            DatabaseMemo.getInstance(it)?.let {
                db = it
            }
        }

        btnCancel.setOnClickListener {
            dismiss()
        }

        btnTambah.setOnClickListener{
            val memo = Memo(
                null,
                etMemo.text.toString(),
                etTanggal.text.toString()
            )


            GlobalScope.launch {
                val totalSaved:Long = db.memoDao().add(memo)

                activity?.runOnUiThread {
                    if (totalSaved >0){
                        Snackbar.make(it, "Data Memo Tersimpan", Snackbar.LENGTH_LONG).show()
                        dismiss()

                        (activity as ProfilActivity).fetchData()
                        
                    } else {
                        Snackbar.make(it, "Data Memo Gagal Tersimpan", Snackbar.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddMemoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddMemoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}