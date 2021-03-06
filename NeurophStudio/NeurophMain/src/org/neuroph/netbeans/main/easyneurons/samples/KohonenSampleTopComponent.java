package org.neuroph.netbeans.main.easyneurons.samples;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.netbeans.api.settings.ConvertAsProperties;
import org.neuroph.core.Connection;
import org.neuroph.core.Layer;
import org.neuroph.core.Neuron;
import org.neuroph.core.events.LearningEvent;
import org.neuroph.core.events.LearningEventListener;
import org.neuroph.netbeans.visual.TrainingController;
import org.neuroph.netbeans.visual.NeuralNetAndDataSet;
import org.neuroph.nnet.Kohonen;
import org.neuroph.nnet.learning.KohonenLearning;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Top component which displays something.
 */
@ConvertAsProperties(dtd = "-//org.neuroph.netbeans.main.easyneurons.samples//KohonenSample//EN",
autostore = false)
public final class KohonenSampleTopComponent extends TopComponent implements LearningEventListener, Runnable {

    private static KohonenSampleTopComponent instance;
    /**
     * path to the icon used by the component and its open action
     */
//    static final String ICON_PATH = "SET/PATH/TO/ICON/HERE";
    private static final String PREFERRED_ID = "KohonenSampleTopComponent";

    public KohonenSampleTopComponent() {
        initComponents();
        setName(NbBundle.getMessage(KohonenSampleTopComponent.class, "CTL_KohonenSampleTopComponent"));
        setToolTipText(NbBundle.getMessage(KohonenSampleTopComponent.class, "HINT_KohonenSampleTopComponent"));
//        setIcon(ImageUtilities.loadImage(ICON_PATH, true));
        putClientProperty(TopComponent.PROP_UNDOCKING_DISABLED, Boolean.TRUE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        controlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        learningRateField = new javax.swing.JTextField();
        IphaseField = new javax.swing.JTextField();
        IIphaseField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        currentIterationField = new javax.swing.JTextField();
        randomizeButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        drawingPanel = drawingPanel = new JPanel () {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                repaintDrawingPanel();
                g.drawImage(imageBuffer, 0, 0, this);
            }

        };

        setLayout(new java.awt.BorderLayout());

        controlPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        controlPanel.setLayout(new java.awt.GridBagLayout());

        org.openide.awt.Mnemonics.setLocalizedText(jLabel1, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.jLabel1.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(jLabel1, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel2, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.jLabel2.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(jLabel2, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel3, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.jLabel3.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(jLabel3, gridBagConstraints);

        learningRateField.setColumns(7);
        learningRateField.setText(org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.learningRateField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(learningRateField, gridBagConstraints);

        IphaseField.setText(org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.IphaseField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(IphaseField, gridBagConstraints);

        IIphaseField.setText(org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.IIphaseField.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(IIphaseField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(jLabel4, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.jLabel4.text")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(jLabel4, gridBagConstraints);

        currentIterationField.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(currentIterationField, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(randomizeButton, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.randomizeButton.text_1")); // NOI18N
        randomizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                randomizeButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(randomizeButton, gridBagConstraints);

        org.openide.awt.Mnemonics.setLocalizedText(startButton, org.openide.util.NbBundle.getMessage(KohonenSampleTopComponent.class, "KohonenSampleTopComponent.startButton.text")); // NOI18N
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        controlPanel.add(startButton, gridBagConstraints);

        add(controlPanel, java.awt.BorderLayout.PAGE_END);

        drawingPanel.setBackground(new java.awt.Color(224, 223, 227));
        drawingPanel.setPreferredSize(new java.awt.Dimension(520, 460));
        drawingPanel.setLayout(new java.awt.BorderLayout());
        add(drawingPanel, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void randomizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_randomizeButtonActionPerformed
        this.displayDataBuffer.clear();
        neuralNetworkAndDataSet.randomize();

        List<Point> weights = getWeightPoints();
        this.displayDataBuffer.add(weights);
        this.drawFromDataBuffer();
    }//GEN-LAST:event_randomizeButtonActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        String learningRateStr = learningRateField.getText().trim().toString();
        String IphaseStr = IphaseField.getText().trim().toString();
        String IIphaseStr = IIphaseField.getText().trim().toString();
        Double learningRate = new Double(learningRateStr);
        Integer Iphase = new Integer(IphaseStr);
        Integer IIphase = new Integer(IIphaseStr);

        trainingController = new TrainingController(neuralNetworkAndDataSet);
        trainingController.setKohonenParams(learningRate, Iphase, IIphase);
        trainingController.train();
    }//GEN-LAST:event_startButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IIphaseField;
    private javax.swing.JTextField IphaseField;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JTextField currentIterationField;
    private javax.swing.JPanel drawingPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField learningRateField;
    private javax.swing.JButton randomizeButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files
     * only, i.e. deserialization routines; otherwise you could get a
     * non-deserialized instance. To obtain the singleton instance, use
     * {@link #findInstance}.
     */
    public static synchronized KohonenSampleTopComponent getDefault() {
        if (instance == null) {
            instance = new KohonenSampleTopComponent();
        }
        return instance;
    }

    /**
     * Obtain the KohonenSampleTopComponent instance. Never call
     * {@link #getDefault} directly!
     */
    public static synchronized KohonenSampleTopComponent findInstance() {
        TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
        if (win == null) {
            Logger.getLogger(KohonenSampleTopComponent.class.getName()).warning(
                    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
            return getDefault();
        }
        if (win instanceof KohonenSampleTopComponent) {
            return (KohonenSampleTopComponent) win;
        }
        Logger.getLogger(KohonenSampleTopComponent.class.getName()).warning(
                "There seem to be multiple components with the '" + PREFERRED_ID
                + "' ID. That is a potential source of errors and unexpected behavior.");
        return getDefault();
    }

    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_ALWAYS;
    }

    @Override
    public void componentOpened() {
        // TODO add custom code on component opening
    }

    @Override
    public void componentClosed() {
        // TODO add custom code on component closing
    }

    void writeProperties(java.util.Properties p) {
        // better to version settings since initial version as advocated at
        // http://wiki.apidesign.org/wiki/PropertyFiles
        p.setProperty("version", "1.0");
        // TODO store your settings
    }

    Object readProperties(java.util.Properties p) {
        if (instance == null) {
            instance = this;
        }
        instance.readPropertiesImpl(p);
        return instance;
    }

    private void readPropertiesImpl(java.util.Properties p) {
        String version = p.getProperty("version");
        // TODO read your settings according to their version
    }

    @Override
    protected String preferredID() {
        return PREFERRED_ID;
    }
    
    
    Image imageBuffer;          // image object for double buffering
    Graphics2D drawingBuffer;   // graphics object from image ojects above used for double buffered drawing
    
    Kohonen neuralNet;
    NeuralNetAndDataSet neuralNetworkAndDataSet;
    TrainingController trainingController;
    
    // position of coordinate begining - used for translation from real values to drawing panel coords
    int X0 = 260;
    int Y0 = 260;
    
    // value of single pixel - also used for translation from real values to drawing panel coords
    double pixVal = 0.004;
            
    private ConcurrentLinkedQueue<List> displayDataBuffer;
    private Thread drawingThread = null;
    private boolean isDrawing = false;

    // called from ViewManager
    public void setNeuralNetworkTrainingController(NeuralNetAndDataSet controller) {
        this.neuralNetworkAndDataSet = controller;
        this.neuralNet = (Kohonen) controller.getNetwork();
        this.displayDataBuffer = new ConcurrentLinkedQueue<List>();
    }

    @Override
    public void run() {

        isDrawing = true;   // set this to indicate that we're in drawing thread

        while (!neuralNetworkAndDataSet.isStoppedTraining()) {   // until the training is completed
            drawFromDataBuffer();                   // draw weights from data buffer
        }

        isDrawing = false;  // set this to indicat ethat we're out of drawing thread
    }

    // initializes drawing buffer, draws axis and weights
    private void drawFromDataBuffer() {

        if (displayDataBuffer.isEmpty()) {
            try {
                Thread.sleep(100); // if there is no data to display wait 100 milisec - it should wait() here until data is available
            } catch (InterruptedException ie) {
            }
            return;
        }

        // if drawing buffer is null, create one
        if (drawingBuffer == null) {
            imageBuffer = drawingPanel.createImage(520, 520);
            drawingBuffer = (Graphics2D) imageBuffer.getGraphics();
        }

        // clear image
        drawingBuffer.clearRect(0, 0, getWidth(), getHeight());
        // draw x and y axis
        drawAxis();

        
        List<Point> weights = displayDataBuffer.poll();
        if (weights != null) {
            drawWeights(weights);
        }

        // ako je minimizovan a radi ovde baca NullPointerException
        // draw image buffer
        this.drawingPanel.getGraphics().drawImage(imageBuffer, 0, 0, this.drawingPanel);

    }

    // draws x and y  axis
    private void drawAxis() {
//		int width = drawingPanel.getWidth();
//		int height = drawingPanel.getHeight();

        this.drawingBuffer.drawLine(260, 0, 260, 460);
        this.drawingBuffer.drawLine(0, 230, 520, 230);
    }

    /**
     * This method does actuall drawing to drawingBuffer
     * @param weights 
     */
    private void drawWeights(List<Point> weights) {
        Point prevPoint = null;

        int i = 0;
        int mapSize = ((KohonenLearning) neuralNet.getLearningRule()).getMapSize(); // duzina

        for (Point p : weights) {
            drawingBuffer.fillOval((int) p.getX(), (int) p.getY(), 8, 8);

            if (prevPoint != null) {
                if (i % mapSize > ((i - 1) % mapSize)) {
                    drawingBuffer.drawLine((int) prevPoint.getX(), (int) prevPoint
                            .getY(), (int) p.getX(), (int) p.getY());
                }
            }

            if (i >= mapSize) {
                Point upPoint = weights.get(i - mapSize);
                drawingBuffer.drawLine((int) upPoint.getX(), (int) upPoint.getY(),
                        (int) p.getX(), (int) p.getY());
            }

            prevPoint = p;
            i++;
        }
    }

    /**
     * Returns all network weights from map layer as collection of points
     * @return 
     */
    private List<Point> getWeightPoints() {
        List<Point> weightPoints = new ArrayList<Point>();
        Layer mapLayer = (Layer) neuralNet.getLayerAt(1);
        //Iterator<Neuron> eN = mapLayer.getNeuronsIterator();
        Neuron[] eN = mapLayer.getNeurons();
        for (Neuron neuron : mapLayer.getNeurons()) {
            //while (eN.hasNext()) {
            //Neuron neuron = eN.next();
            Connection[] inputs = neuron.getInputConnections();
            double wX = inputs[0].getWeight().value;
            double wY = inputs[1].getWeight().value;
            Point point = createPoint(wX, wY);
            weightPoints.add(point);
        }
        return weightPoints;
    }

    /**
     * Creates and returns coordinate point in drawing panel out of given x and y values
     * @param xVal
     * @param yVal
     * @return 
     */
    private Point createPoint(double xVal, double yVal) {
        int xPix = (int) (xVal / pixVal);
        int yPix = (int) (yVal / pixVal);
        int xCoord = X0 + xPix;
        int yCoord = Y0 - yPix;
        return new Point(xCoord, yCoord);
    }

    public void stopTraining() {
        neuralNetworkAndDataSet.stopTraining();
        this.displayDataBuffer.clear();
    }
    
    public void repaintDrawingPanel() {
        if (drawingBuffer == null) {
            imageBuffer = drawingPanel.createImage(520, 460);
            drawingBuffer = (Graphics2D) imageBuffer.getGraphics();
        }
        drawAxis();
        List<Point> weights = getWeightPoints();
        drawWeights(weights);

    }

    /**
     * 
     * @param le 
     */
    @Override
    public void handleLearningEvent(LearningEvent le) {
        KohonenLearning kl = (KohonenLearning) (neuralNetworkAndDataSet.getNetwork()
                .getLearningRule());
        this.currentIterationField.setText(kl.getIteration().toString()); // ovo isto prebaciti u negede thread

        // get all network weights
        List<Point> weights = getWeightPoints();
        this.displayDataBuffer.add(weights);

        if (!isDrawing) {
            drawingThread = new Thread(this);
            drawingThread.start();
        }
    }
}
