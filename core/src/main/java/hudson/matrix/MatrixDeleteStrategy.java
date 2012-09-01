package hudson.matrix;

import java.io.IOException;

import hudson.ExtensionPoint;
import hudson.model.AbstractDescribableImpl;

/**
 * Controls how the {@link MatrixBuild} and its sub-builds are deleted. 
 * 
 * @author vjuranek
 * @since 1.481
 */
public abstract class MatrixDeleteStrategy extends AbstractDescribableImpl<MatrixDeleteStrategy> implements ExtensionPoint {
    
    public abstract void doDelete(MatrixBuild b) throws MatrixDeleteException, IOException;
    
    @Override
    public MatrixDeleteStrategyDescriptor getDescriptor() {
        return (MatrixDeleteStrategyDescriptor)super.getDescriptor();
    }

    public static class MatrixDeleteException extends RuntimeException {
        
        public MatrixDeleteException(String message) {
            super(message);
        }
        
        private static final long serialVersionUID = 1L;
    }
    
}
