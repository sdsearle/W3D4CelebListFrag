package com.example.admin.w3d4celeblistfrag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CelebInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CelebInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CelebInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private TextView tvName, tvAge, tvHeight, tvFame;
    private ImageView ivImg;

    // TODO: Rename and change types of parameters
    private Celebrity mParam1;

    private OnFragmentInteractionListener mListener;

    public CelebInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment CelebInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CelebInfoFragment newInstance(Celebrity param1) {
        CelebInfoFragment fragment = new CelebInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Celebrity) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        tvName = view.findViewById(R.id.tvCelebName);
        tvAge = view.findViewById(R.id.tvCelebAge);
        tvFame = view.findViewById(R.id.tvCelebFame);
        tvHeight = view.findViewById(R.id.tvCelebHeight);

        ivImg = view.findViewById(R.id.ivCelebImg2);

        ivImg.setImageResource(mParam1.getPicID());

        tvName.setText("NAME: " + mParam1.getName());
        tvAge.setText("AGE: " + mParam1.getAge());
        tvHeight.setText("HEIGHT: " + mParam1.getHeight());
        tvFame.setText("FAMOUS FOR: " + mParam1.getMovie());

        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //Bitmap tmp = BitmapFactory.decodeResource(getContext().getResources(), mParam1.getPicID());
        //ivImg.setImageBitmap(tmp);

        Log.d("TAG", "onCreateView: " + mParam1.getPicID());


        return inflater.inflate(R.layout.fragment_celeb_info, container, false);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
