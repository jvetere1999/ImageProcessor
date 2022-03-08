package processor;

import component.Component;
import component.ConnectedComponents;
import image.Image;

import java.util.ArrayList;

public class ComponentProcessor extends Processor {
    String                  fileName;
    Image                   original;
    ProcessType             type;
    ConnectedComponents     components;

    public ComponentProcessor(String _fileName, ProcessType _type) {
        images      = new ArrayList<>();
        fileName    = _fileName;
        type        = _type;

    }
    @Override
    public void run() {
        original            = new Image(fileName);
        images.add(original);
        components          = new ConnectedComponents(original);
        ArrayList<Component> ogArr;
        ogArr               = new ArrayList<>(components.asList());
        components.componentPrune(50,100000);

        ArrayList<Component> arr        = components.asList();
        ArrayList<Component> pruned     = components.prunedAsList();
        fileName = fileName.substring(0, fileName.indexOf("."));
        images.add(new Image(fileName +"pruned.png",
                arr,
                original.width,
                original.height));


        images.add(new Image(fileName +"onlyPruned.png",
                pruned,
                original.width,
                original.height));

        images.add(new Image(fileName +"componentImage.png",
                ogArr,
                original.width,
                original.height));
    }


    @Override
    public ArrayList<Image> getImages() {
        return images;
    }
}
