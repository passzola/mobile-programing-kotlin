package edu.miu.quizapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import edu.miu.quizapp.R
import edu.miu.quizapp.db.Quiz
import edu.miu.quizapp.db.QuizDatabase
import edu.miu.quizapp.utils.BaseFragment
import edu.miu.quizapp.utils.PrefManager
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment() {

    private lateinit var tvWelcome: TextView
    private var prefManager: PrefManager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        prefManager = PrefManager(context)
        val view = inflater.inflate(R.layout.fragment_splash, container, false)
        tvWelcome = view.findViewById(R.id.logo_welcome)
        addQuestionsToDB()
        return view
    }

    override fun onResume(){
        super.onResume()
        tvWelcome.postDelayed({
            if (!prefManager?.isFirstTimeLaunch()!!) {
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_homeFragment)
            }else{
                Navigation.findNavController(requireView()).navigate(R.id.action_splashFragment_to_welcomeFragment)
            }
        }, 1000)
    }

    fun addQuestionsToDB(){
        val quiz1 = Quiz(1L,"1) Android is Developed by","A. Apple", "B. Microsoft","C. Google","D. Android Inc","d","Answer: (d) Android Inc\n" +
                "\n" +
                "Explanation: Android is a software package and linux based operating system for mobile devices developed by Android Inc.")
        val quiz2 = Quiz(2L,"2) What does API stand for?", "A. Application Programming Interface","B. Application Protocol Interface","C. Accellerated Programming Interface","D. None of the above","a","Answer: (a) Application Programming Interface\n" +
                "\n" +
                "Explanation:  API stands for Application Programming Interface.")
        val quiz3 = Quiz(3L,"3) For which of the following Android is mainly developed?","A. Servers", "B. Desktops","C. Laptops","D. Mobile devices","d","Answer: (d) Mobile devices\n" +
                "\n" +
                "Explanation: Android is a software package and a Linux-based operating system specially designed for touch-screen mobile devices like smartphones and tablets.")
        val quiz4 = Quiz(4L,"4) Android Web Browser is Based On?","A. Chrome", "B. Open-source Webkit","C. Safari","D. Firefox","b","Answer: (b) Open-source Webkit\n" +
                "\n" +
                "Explanation: Android Web Browser is based on Open-source Webkit.")
        val quiz5 = Quiz(5L,"5) Which one is the latest version of android?","A. Android 8", "B. Android 9","C. Android 10","D. Android 11","d","Answer: (d) Android 11\n" +
                "\n" +
                "Explanation: The latest version of android is Android 11.")
        val quiz6 = Quiz(6L,"6) Android is based on which of the following language?","A. Java", "B. C++","C. C","D. None of the above","a","Answer: (a) Java\n" +
                "\n" +
                "Explanation: Java language is mainly used to write the android code even though other languages can be used.")
        val quiz7 = Quiz(7L,"7) APK stands for -","A. Android Phone Kit", "B. Android Page Kit","C. Android Package Kit","D. None of the above","c","Answer: (c) Android Package Kit\n" +
                "\n" +
                "Explanation: An APK is a short form of the Android Package Kit. An APK file is the file format used to install the applications on the android operating system.")
        val quiz8 = Quiz(8L,"8) Which Media Format is not Supported by Android?","A. MP4", "B. AVI","C. MIDI","D. MPEG","b","Answer: (b) AVI\n" +
                "\n" +
                "Explanation: Android support MP4, MIDI, and MPEG but not support AVI")
        val quiz9 = Quiz(9L,"9) Which of the following converts Java byte code into Dalvik byte code?","A. Dalvik converter", "B. Dex compiler","C. Mobile interpretive compiler (MIC)","D. None of the above","b","Answer: (b) Dex compiler\n" +
                "\n" +
                "Explanation: The Dex compiler converts the class files into a .dex file that runs on the Dalvik VM. Multiple class files are converted into one dex file.")
        val quiz10 = Quiz(10L,"10) How can we stop the services in android?","A. By using the stopSelf() and stopService() method", "B. By using the finish() method","C. By using system.exit() method","D. None of the above","a","Answer: (a) By using the stopSelf() and stopService() method\n" +
                "\n" +
                "Explanation: A service is started when a component (like activity) calls the startService() method; now, it runs in the background indefinitely. It is stopped by the stopService() method. The service can stop itself by calling the stopSelf() method.")
        val quiz11 = Quiz(11L,"11) What is an activity in android?","A. android class", "B. android package","C. A single screen in an application with supporting java code","D. None of the above","c","Answer: (c) A single screen in an application with supporting java code\n" +
                "\n" +
                "Explanation: An activity is a single screen in android. It is like a window or frame of Java. By the help of activity, you can place all your UI components or widgets in a single screen. Activity is like a frame or window in java that represents GUI. It represents one screen of android.")
        val quiz12 = Quiz(12L,"12) In which Directory XML layout Files are stored?","A. /assets", "B. /src","C. /res/value","D. /res/layout","d","Answer: (d) /res/layout\n" +
                "\n" +
                "Explanation: There are different folder in android project among those folder /res/layout is the one which we use to store layout file.")
        val quiz13 = Quiz(13L,"13) ADB stands for -","A. Android debug bridge", "B. Android delete bridge","C. Android destroy bridge","D. None of the above","a","Answer: (a) Android debug bridge\n" +
                "\n" +
                "Explanation: ADB stands for Android Debug Bridge. It is a command-line tool that is used to communicate with the emulator instance.")
        val quiz14 = Quiz(14L,"14) On which of the following, developers can test the application, during developing the android applications?",
            "A. Third-party emulators", "B. Emulator included in Android SDK","C. Physical android phone","D. All of the above","d","Answer: (d) All of the above\n" +
                    "\n" +
                    "Explanation: We can use the Android emulator, physical android phone, or third-party emulator as a target device to execute and test our Android application.")
        val quiz15 = Quiz(15L,"15) What is APK in android?","A. Android pack", "B. Android packages","C. Android Package Kit","D. None of the above","c","Answer: (c) Android Package Kit\n" +
                "\n" +
                "Explanation: APK stands for Android Package Kit.")

        launch {
            context?.let {
                QuizDatabase(it)
                    .getQuizDao().deleteAllQuiz()
                QuizDatabase(it)
                    .getQuizDao().addQuizzes(quiz1,quiz2,quiz3,quiz4,quiz5,quiz6,quiz7,quiz8,
                    quiz9,quiz10,quiz11,quiz12,quiz13,quiz14,quiz15)
            }
        }
    }

}