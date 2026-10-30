package com.example.snake3d;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
  private SnakeRenderer renderer;
  @Override public void onCreate(Bundle b) { super.onCreate(b); getWindow().getDecorView().setSystemUiVisibility(5894|1024|512);
    FrameLayout root=new FrameLayout(this); renderer=new SnakeRenderer(this); android.opengl.GLSurfaceView gl=new android.opengl.GLSurfaceView(this); gl.setEGLContextClientVersion(2); gl.setRenderer(renderer); gl.setRenderMode(android.opengl.GLSurfaceView.RENDERMODE_CONTINUOUSLY); root.addView(gl);
    TextView title=new TextView(this); title.setText("SNAKE 3D   •   SCORE: 0"); title.setTextColor(Color.WHITE); title.setTextSize(18); title.setPadding(22,14,22,14); FrameLayout.LayoutParams tp=new FrameLayout.LayoutParams(-2,-2,Gravity.TOP|Gravity.CENTER_HORIZONTAL); root.addView(title,tp); renderer.setScoreView(title);
    String[] labels={"▲","◀","▼","▶"}; int[] dirs={0,1,2,3}; int[][] pos={{1,0},{0,1},{1,2},{2,1}};
    for(int i=0;i<4;i++){ final int d=dirs[i]; Button btn=new Button(this); btn.setText(labels[i]); btn.setTextSize(20); btn.setTextColor(Color.WHITE); btn.setBackgroundTintList(android.content.res.ColorStateList.valueOf(0x99556677)); FrameLayout.LayoutParams p=new FrameLayout.LayoutParams(64,58,Gravity.BOTTOM|Gravity.LEFT); p.leftMargin=18+pos[i][0]*65; p.bottomMargin=16+(2-pos[i][1])*58; root.addView(btn,p); btn.setOnClickListener(v->renderer.turn(d)); }
    Button restart=new Button(this); restart.setText("RESTART"); restart.setTextSize(12); FrameLayout.LayoutParams rp=new FrameLayout.LayoutParams(-2,52,Gravity.RIGHT|Gravity.BOTTOM); rp.rightMargin=18; rp.bottomMargin=18; root.addView(restart,rp); restart.setOnClickListener(v->renderer.restart()); setContentView(root);
  }
  @Override protected void onPause(){super.onPause();}
  @Override protected void onResume(){super.onResume();}
}
