package com.example.quran.ui.quran.quranIndex;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.quran.data.utils.IndexTabsUtils;

public class QuranIndexViewModel extends ViewModel {

        private int[] tabsList;

        public QuranIndexViewModel() {
            tabsList = IndexTabsUtils.QURAN_INDEX_TABS;
        }

        public int getTabAt(int position) {

            return tabsList[position];
        }


    }

