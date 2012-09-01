package hudson.matrix;

import hudson.DescriptorExtensionList;
import hudson.model.Descriptor;
import jenkins.model.Jenkins;

/**
 * {@link Descriptor} for {@link MatrixDeleteStrategy}.
 *
 * @author vjuranek
 * @since 1.481
 */
public abstract class MatrixDeleteStrategyDescriptor extends Descriptor<MatrixDeleteStrategy> {
    protected MatrixDeleteStrategyDescriptor(Class<? extends MatrixDeleteStrategy> clazz) {
        super(clazz);
    }

    protected MatrixDeleteStrategyDescriptor() {
    }

    /**
     * Returns all the registered {@link MatrixDeleteStrategyDescriptor}s.
     */
    public static DescriptorExtensionList<MatrixDeleteStrategy,MatrixDeleteStrategyDescriptor> all() {
        return Jenkins.getInstance().<MatrixDeleteStrategy,MatrixDeleteStrategyDescriptor>getDescriptorList(MatrixDeleteStrategy.class);
    }
}
