package com.example.gestures

import android.health.connect.datatypes.units.Velocity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import androidx.core.view.GestureDetectorCompat
import org.w3c.dom.Text

//import kotlinx.android.synthetic.main.activity_main.getGestureText

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    var gDetector: GestureDetectorCompat? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.getGestureText)
        val swipe = findViewById<TextView>(R.id.swipe)
        val resetFlinger = findViewById<Button>(R.id.button)

//        context is this app. Listener is this screen.
        this.gDetector = GestureDetectorCompat(this, this)
        gDetector?.setOnDoubleTapListener(this)

        resetFlinger.setOnClickListener() {
            swipe.x = 500F
            swipe.y = 2200F
        }

    }

    // make touch events pass to the gDetector instead of default
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            this.gDetector?.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    override fun onDown(e: MotionEvent): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onDown"
        return true
    }

    override fun onShowPress(e: MotionEvent) {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onShowPress"
    }

    override fun onSingleTapUp(e: MotionEvent): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onSingleTapUp"
        return true
    }

    override fun onScroll(
        e1: MotionEvent?,
        e2: MotionEvent,
        distanceX: Float,
        distanceY: Float
    ): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onScroll"
        return true
    }

    override fun onLongPress(e: MotionEvent) {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onLongPress"
    }

    override fun onFling(
        e1: MotionEvent?,
        e2: MotionEvent,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onFling"

        val swipe = findViewById<Button>(R.id.swipe)
        swipe.x += velocityX / 10
        swipe.y += velocityY / 10

        val velText = findViewById<TextView>(R.id.vel)
        velText.text = "X: ${velocityX}, Y: ${velocityY}"
        return true
    }

    override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onSingleTapConfirm"
        return true
    }

    override fun onDoubleTap(e: MotionEvent): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onDoubleTap"
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent): Boolean {
        val text = findViewById<TextView>(R.id.getGestureText)
        text.text = "onDoubleTapEvent"
        return true
    }
}