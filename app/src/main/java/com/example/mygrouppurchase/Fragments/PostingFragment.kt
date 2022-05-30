package com.example.mygrouppurchase.Fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.mygrouppurchase.R
import com.example.mygrouppurchase.board.BoardInsideActivity
import com.example.mygrouppurchase.board.BoardListLVAdapter
import com.example.mygrouppurchase.board.BoardModel
import com.example.mygrouppurchase.board.BoardWriteActivity
import com.example.mygrouppurchase.databinding.FragmentPostingBinding
import com.example.mygrouppurchase.utils.FBRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class PostingFragment : Fragment() { //'게시글' 프래그먼트
    private lateinit var binding : FragmentPostingBinding

    private val boardDataList = mutableListOf<BoardModel>()

    private val TAG = PostingFragment::class.java.simpleName

    private lateinit var boardRVAdapter : BoardListLVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_posting, container, false)

        //사용자가 작성한 BoardModel을 리스트화시켜서 어댑터에 담아줌
        boardRVAdapter = BoardListLVAdapter(boardDataList)
        binding.boardListView.adapter = boardRVAdapter

        //<글 리스트 목록 클릭> 시 -> 이 데이터를 그대로 다른 액티비티로 보내는 방법
        //1) listview 속 데이터를 하나 하나 전달하는 방법
        //2) Firebase 에 있는 board 에 대한 데이터의 id 값 기반으로 다시 데이터를 보내주는 방법

        //이 글 목록 리스트를 클릭 시 -> 이벤트 처리 (리스트 목록 속 데이터값 하나 하나를 intent에 전달 해주기
        binding.boardListView.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(context, BoardInsideActivity::class.java)
            intent.putExtra("title", boardDataList[position].title)
            intent.putExtra("content", boardDataList[position].content)
            intent.putExtra("time", boardDataList[position].time)
            startActivity(intent)
        }

        binding.writeBtn.setOnClickListener {
            val intent = Intent(context, BoardWriteActivity::class.java)
            startActivity(intent)
        }

        binding.homeTap.setOnClickListener{
            it.findNavController().navigate(R.id.action_postingFragment_to_homeFragment)
        }
        binding.talkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_talkFragment)
        }
        binding.bookmarkTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_promiseFragment)
        }
        binding.storeTap.setOnClickListener {
            it.findNavController().navigate(R.id.action_postingFragment_to_personalFragment)
        }
        getFBBoardData()

        return binding.root
    }

    //제발 좀 되라 ㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠㅠ

    private fun getFBBoardData(){

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                //데이터 중복 막기 위해서 한 번 지우고 실행해주어야 함
                boardDataList.clear()

                for (dataModel in dataSnapshot.children) {

                    Log.d(TAG, dataModel.toString())
                    val item = dataModel.getValue(BoardModel::class.java)
                    boardDataList.add(item!!)
                }
                //리스트를 최신순으로 보이기 위해 -> 리스트 뒤집기
                boardDataList.reverse()

                boardRVAdapter.notifyDataSetChanged()
                Log.d(TAG, boardDataList.toString())

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException())
            }
        }
        FBRef.boardRef.addValueEventListener(postListener)

    }


}



