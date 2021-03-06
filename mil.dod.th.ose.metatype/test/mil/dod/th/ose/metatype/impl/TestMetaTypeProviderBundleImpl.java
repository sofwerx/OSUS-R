//==============================================================================
// This software is part of the Open Standard for Unattended Sensors (OSUS)
// reference implementation (OSUS-R).
//
// To the extent possible under law, the author(s) have dedicated all copyright
// and related and neighboring rights to this software to the public domain
// worldwide. This software is distributed without any warranty.
//
// You should have received a copy of the CC0 Public Domain Dedication along
// with this software. If not, see
// <http://creativecommons.org/publicdomain/zero/1.0/>.
//==============================================================================
package mil.dod.th.ose.metatype.impl;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

public class TestMetaTypeProviderBundleImpl
{
    /**
     * Verify bundle returned is the one associated with {@link BundleContext}.
     */
    @Test
    public void testGetBundle() throws Exception 
    {
        BundleContext context = mock(BundleContext.class);
        Bundle bundle = mock(Bundle.class);
        when(context.getBundle()).thenReturn(bundle);
        
        MetaTypeProviderBundleImpl sut = new MetaTypeProviderBundleImpl();
        sut.activate(context);
        
        assertThat(sut.getBundle(), is(bundle));
    }
}
