package org.yourorghere;

import com.sun.opengl.util.Animator;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;



/**
 * Gear.java <BR>
 * author: Brian Paul (converted to Java by Ron Cemer and Sven Goethel) <P>
 *
 * This version is equal to Brian Paul's version 1.2 1999/10/21
 */
public class Gear implements GLEventListener {

    public static void main(String[] args) {
        Frame frame = new Frame("Simple JOGL Application");
        GLCanvas canvas = new GLCanvas();

        canvas.addGLEventListener(new Gear());
        frame.add(canvas);
        frame.setSize(802, 802);
        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                // Run this on another thread than the AWT event queue to
                // make sure the call to Animator.stop() completes before
                // exiting
                new Thread(new Runnable() {

                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
        // Center frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        animator.start();
    }

    public void init(GLAutoDrawable drawable) {
        // Use debug pipeline
        // drawable.setGL(new DebugGL(drawable.getGL()));

        GL gl = drawable.getGL();
        System.err.println("INIT GL IS: " + gl.getClass().getName());
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);

    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();        
        GLUquadric q;
        q = glu.gluNewQuadric();        
        //gl.glLoadIdentity();
        
        gl.glViewport(0,0,400,400);
        gl.glScissor(0, 0, 400, 400);
        gl.glEnable(gl.GL_SCISSOR_TEST);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_LINE);
        
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XFFFF);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(-0.65, -0.05);
        gl.glVertex2d(-0.65, 0.05);
        gl.glVertex2d(0.65, 0.05);
        gl.glVertex2d(0.65, -0.05);
        gl.glEnd();
        
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XFFFF);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(-0.55, 0.05);
        gl.glVertex2d(-0.55, -0.05);
        
        gl.glVertex2d(-0.37, 0.05);
        gl.glVertex2d(-0.37, -0.05);
        
        gl.glVertex2d(-0.1, 0.05);
        gl.glVertex2d(-0.1, -0.05);
        
        gl.glVertex2d(0.55, 0.05);
        gl.glVertex2d(0.55, -0.05);     
        
        gl.glVertex2d(0.37, 0.05);
        gl.glVertex2d(0.37, -0.05);
        
        gl.glVertex2d(0.1, 0.05);
        gl.glVertex2d(0.1, -0.05);

        gl.glEnd();
        
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XF00F);//пунктир
        gl.glEnable(GL.GL_LINE_STIPPLE);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(0.2, 0.05);
        gl.glVertex2d( 0.2, -0.05);
        
        gl.glVertex2d(-0.2,  0.05);
        gl.glVertex2d(-0.2, -0.05);
        
        gl.glVertex2d(0.47, 0.05);
        gl.glVertex2d(0.47, -0.05);
        
        gl.glVertex2d(-0.47, 0.05);
        gl.glVertex2d(-0.47, -0.05);
        
        gl.glVertex2d(-0.5, 0.05);
        gl.glVertex2d(-0.5, -0.05);
        
        gl.glVertex2d(0.5, 0.05);
        gl.glVertex2d(0.5, -0.05);
        gl.glEnd();
        
        gl.glLineWidth(1);
        gl.glLineStipple(2, (short)0X8FF1);
        gl.glEnable(GL.GL_LINE_STIPPLE);//осевая
        gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(0, 0.1);
            gl.glVertex2d(0, -0.1);
            
            gl.glVertex2d(-0.9, 0);
            gl.glVertex2d( 0.9, 0);
        gl.glEnd();
        
        
        
        
        gl.glViewport(402, 0, 400, 400);
        gl.glScissor(402, 0, 400, 400);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_FILL);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glPushMatrix();    
        gl.glRotatef(210.0f, 1, 0, 0); 
        gl.glRotatef(20.0f, 0, 1, 0); 
            gl.glPushMatrix();                      
            gl.glColor3f(0.5f, 0.5f, 0.5f);
                gl.glPushMatrix();
                gl.glRotatef(180.0f, 1, 0, 0);
                glu.gluDisk(q, 0.5, 0.2, 24, 1);
                gl.glPopMatrix();
            gl.glColor3f(0.5f, 0.5f, 0.5f);
            glu.gluCylinder(q, 0.5, 0.5, 0.05, 24, 1);
            glu.gluCylinder(q, -0.2, -0.2, 0.05, 24, 1);
            gl.glTranslatef(0.0f, 0.0f, 0.05f);
                glu.gluDisk(q, 0.5, 0.2, 24, 1);
            gl.glPopMatrix();
            float i;
            i = 0;
            while (i<360)
            {
                gl.glPushMatrix();
                gl.glRotatef(i, 0, 0, 1);
                gl.glTranslatef(0,0.4f,0.001f);
                gl.glBegin(GL.GL_QUADS);
                    gl.glVertex3f( 0.1f, 0, 0);//4
                    gl.glVertex3f( 0.1f, 0.3f, 0);//3
                    gl.glVertex3f(-0.1f, 0.3f, 0);//2
                    gl.glVertex3f(-0.1f, 0, 0); //1
                    
                    gl.glVertex3f(-0.1f, 0, 0.048f);                
                    gl.glVertex3f(-0.1f, 0.3f, 0.048f);
                    gl.glVertex3f( 0.1f, 0.3f, 0.048f);
                    gl.glVertex3f( 0.1f, 0, 0.048f);
                    
                    
                    gl.glVertex3f(-0.1f, 0, 0);  //1
                    gl.glVertex3f(-0.1f, 0.3f, 0);//2                    
                    gl.glVertex3f(-0.1f, 0.3f, 0.048f);//3
                    gl.glVertex3f(-0.1f, 0, 0.048f);//4
                    
                    
                    
                    gl.glVertex3f(0.1f, 0, 0.048f);//4
                    gl.glVertex3f(0.1f, 0.3f, 0.048f);//3
                    gl.glVertex3f(0.1f, 0.3f, 0);//2
                    gl.glVertex3f(0.1f, 0, 0);    //1            
                    
                    
                    
                    gl.glVertex3f(0.1f, 0.3f, 0);//4
                    gl.glVertex3f(0.1f, 0.3f, 0.048f);//3
                    gl.glVertex3f(-0.1f, 0.3f, 0.048f);//2
                    gl.glVertex3f(-0.1f, 0.3f, 0);      //1          
                    
                    
                    
                gl.glEnd();
                i=i+60;
                gl.glPopMatrix();
            }
            gl.glPopMatrix();
            
            float[] position0 = { -8.0f, 10.0f, -2.0f, 1.0f};//освещение. если четвертый не равен 0, то удаленный источник
            float[] dir = { 0.0f, 0.0f, 0.0f, 0.0f};
            gl.glEnable(GL.GL_LIGHTING);
            gl.glEnable(GL.GL_LIGHT0);
            gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position0, 0); //настройка векторных характеристик
            gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPOT_DIRECTION, dir, 0);            
            gl.glEnable(GL.GL_DEPTH_TEST);
            

            
        
        gl.glViewport(0, 402, 400, 400);
        gl.glScissor(0, 402, 400, 400);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_LINE);        

        int n;
        float x,y,R,alpha,da;
        
        R=0.5f;
        alpha = 0.0f;
        n=90;
        da=(float)(2*Math.PI/n);
        gl.glPushMatrix();        
            int d;
            d=0;
            gl.glRotatef(41, 0, 0, 1);
            while (d<6)
            {
            
            gl.glLineWidth(2);
            gl.glLineStipple(1, (short)0XFFFF);
            gl.glBegin(GL.GL_LINE_STRIP);
            while(alpha<=(2*Math.PI/360)*40)
            {
                x=(float)(R*Math.cos(alpha));
                y=(float)(R*Math.sin(alpha));
                gl.glVertex2f(x,y);
                alpha = alpha+da;
            }
            alpha = 0;
            d=d+1;
            gl.glEnd();
            gl.glRotatef(60, 0, 0, 1);
            }
        gl.glPopMatrix();
        
        R=0.2f;
        alpha = 0;
        n=32;
        da=(float)(2*Math.PI/n);
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XFFFF);
        gl.glBegin(GL.GL_LINE_LOOP);
        while(alpha<=2*Math.PI)
        {
            x=(float)(R*Math.cos(alpha));
            y=(float)(R*Math.sin(alpha));
            gl.glVertex2f(x,y);
            alpha = alpha+da;
        }
        gl.glEnd();
        
        i=0;
        while (i<360)
            {
                gl.glPushMatrix();
                gl.glRotatef(i, 0, 0, 1);
                gl.glTranslatef(0,0.49f,0.001f);
                gl.glLineWidth(2);
                gl.glLineStipple(1, (short)0XFFFF);
                gl.glBegin(GL.GL_LINE_STRIP);
                    gl.glVertex3f(-0.1f, 0, 0);                
                    gl.glVertex3f(-0.1f, 0.21f, 0);
                    gl.glVertex3f( 0.1f, 0.21f, 0);
                    gl.glVertex3f( 0.1f, 0, 0);
                gl.glEnd();
                i=i+60;
                gl.glPopMatrix();
            }
        
        gl.glLineWidth(1);
        gl.glLineStipple(2, (short)0X8FF1); //осевая
        gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(0, 0.9);
            gl.glVertex2d(0, -0.9);
            
            gl.glVertex2d(-0.9, 0);
            gl.glVertex2d( 0.9, 0);
        gl.glEnd();
        


        
        gl.glViewport(402, 402, 400, 400);
        gl.glScissor(402, 402, 400, 400);
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPolygonMode(GL.GL_FRONT_AND_BACK,GL.GL_LINE);        

        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XFFFF);
        gl.glBegin(GL.GL_LINE_LOOP);
        gl.glVertex2d(-0.05, -0.70);
        gl.glVertex2d(-0.05, 0.70);
        gl.glVertex2d(0.05, 0.70);
        gl.glVertex2d(0.05, -0.70);
        gl.glEnd();
        
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XFFFF);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(-0.05, 0.49);
        gl.glVertex2d( 0.05, 0.49);
        
        gl.glVertex2d(-0.05, 0.43);
        gl.glVertex2d( 0.05, 0.43);        
        
        gl.glVertex2d(-0.05, 0.26);
        gl.glVertex2d( 0.05, 0.26);
        
        gl.glVertex2d(-0.05, 0.16);
        gl.glVertex2d( 0.05, 0.16);
        
        
        
        gl.glVertex2d(-0.05, -0.49);
        gl.glVertex2d( 0.05, -0.49);
        
        gl.glVertex2d(-0.05, -0.43);
        gl.glVertex2d( 0.05, -0.43);        
        
        gl.glVertex2d(-0.05, -0.26);
        gl.glVertex2d( 0.05, -0.26);
        
        gl.glVertex2d(-0.05, -0.16);
        gl.glVertex2d( 0.05, -0.16);
        gl.glEnd();
        
                
        gl.glLineWidth(2);
        gl.glLineStipple(1, (short)0XF00F);//пунктир
        gl.glEnable(GL.GL_LINE_STIPPLE);
        gl.glBegin(GL.GL_LINES);
        gl.glVertex2d(-0.05, 0.2);
        gl.glVertex2d( 0.05, 0.2);
        
        gl.glVertex2d(-0.05, -0.2);
        gl.glVertex2d( 0.05, -0.2);
        
        gl.glVertex2d(-0.05, 0.33);
        gl.glVertex2d(0.05, 0.33);
        
        gl.glVertex2d(-0.05, -0.33);
        gl.glVertex2d(0.05, -0.33);
        gl.glEnd();
        
        gl.glLineWidth(1);
        gl.glLineStipple(2, (short)0X8FF1);
        gl.glEnable(GL.GL_LINE_STIPPLE);//осевая
        gl.glBegin(GL.GL_LINES);
            gl.glVertex2d(0, 0.9);
            gl.glVertex2d(0, -0.9);
            
            gl.glVertex2d(-0.1, 0);
            gl.glVertex2d( 0.1, 0);
        gl.glEnd();

        

        // Flush all drawing operations to the graphics card
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}

