package com.example.nitin.desichain;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CustomerService extends Fragment {


    public CustomerService() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_customer,container,false);

        TextView textTermsConditionsHeader= (TextView) view.findViewById(R.id.termsCondition);
        textTermsConditionsHeader.setText("Terms & Conditions");
        textTermsConditionsHeader.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        TextView textTermsConditionsText = (TextView) view.findViewById(R.id.termsandCondtionsText);
        textTermsConditionsText.setText("Please READ Terms and Conditions Carefully and Thoroughly before Purchase. Buying any product on our Store means that you agree to all the terms and conditions of the sale." +
                "If you do not agree to ANY of the outlined terms and conditions please do not click on buy as we will not accept any variations to our terms unless by prior written arrangement.\n" +
                "\n Please check the products you are buying are exactly what you are looking for. You have every opportunity to leave prior entering into the purchase agreement without cause for us to involve ourselves with administering the transaction and incurring costs to do so or suffering any loss in the process.\n" +
                "\n Accidental purchase is unacceptable as it is your responsibility to have knowledge of the use of our Site and warnings are provided prior to enter into this agreement.\n" +
                "\n All listings have been described by us to the best of our ability, with sincere honesty and integrity. We are open to your questions/ suggestions if you have any.\n" +
                "\n Unless expressly stated otherwise all items offered for sale are Brand New and Shipped from New Delhi (INDIA).\n" +
                "\n Guaranteed as described, Pictures or Images shown are exactly same as shown here.However,\n" +
                "\n1. Dimensions are indicative and minor differences are possible in case of some of the items.\n" +
                "2. The actual colors/ finishes may differ slightly from the image online.\n" +
                "3. Slight variations in size may occur in case of handmade items.\n" +
                "\n" +
                "All orders are shipped from New Delhi, India within 1-2 business days of receiving the cleared payment. Some items like Machinery, Wholesale Job Lots, heavy parcels, bulk orders or products that need to be customized may take up to 10 to 15 days.\n" +
                "\nWe cannot accept responsibility for conditions of Fitting, Use or any consequential loss or damage arising from same.");

        TextView customerServiceText = (TextView) view.findViewById(R.id.customerServicePolicy);
        customerServiceText.setText("Customer Care is utmost important and our top Priority. We, DesiChain, always put our 100% to securely send your Orders on time and we are proud to have lots of happy customers worldwide.\n" +
                "\n" +
                "\n" +
                "If you have any problem/ query with the item(s), have any question, or simply need help - please contact us - we are here to help you and will not leave you in the cold!!!\n" +
                "\n" +
                "We, at DesiChain, always try to resolve the problem/ query at the earliest based on our Policies.\n" +
                "\n" +
                "\n" +
                "Please contact us with any questions or concerns through “Contact Us” page form or directly call Customer Care Number.");
        return view;

    }

}
