package imagetool;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.annotation.BeforeStage;
import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import org.jhotdraw.draw.*;
import org.jhotdraw.samples.svg.SVGCreateFromFileTool;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import org.mockito.Mockito;

import javax.swing.*;
import java.io.File;

public class GivenImageToolPressed extends Stage<GivenImageToolPressed> {

    @ProvidedScenarioState
    private SVGCreateFromFileTool createFromFileTool;
    @ProvidedScenarioState
    private DrawingEditor editor;
    private JFileChooser fileChooser;
    private DrawingView view;
    private String testImagePath;

    @BeforeStage
    private void before() {
        editor = new DefaultDrawingEditor();
        view = new DefaultDrawingView();
        view.setDrawing(new DefaultDrawing());
        createFromFileTool = new SVGCreateFromFileTool(new SVGImageFigure(), new SVGGroupFigure());
        editor.setActiveView(view);
        fileChooser = Mockito.mock(JFileChooser.class);
        Mockito.when(fileChooser.showOpenDialog(view.getComponent())).thenReturn(JFileChooser.APPROVE_OPTION);
        testImagePath = "src/test/java/imagetool/test_image.jpg";
        Mockito.when(fileChooser.getSelectedFile()).thenReturn(new File(testImagePath));
        createFromFileTool.setFileChooser(fileChooser);
    }

    public GivenImageToolPressed imageToolPressed() {
        editor.setTool(createFromFileTool);
        return self();
    }
}