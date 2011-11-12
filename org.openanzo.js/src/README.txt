The dojo, dijit, dojox, and util directories contain
the source distribution of dojo (ignoring the 'demos' directory) as obtained by doing:
svn export http://svn.dojotoolkit.org/src/tags/release-1.3.2

The source was committed to the OpenAnzo.org SVN repo at revision 4400.

There are some minor patches to the Dojo source such as the one applied in changeset 4401 to dijit/Dialog.js.

The source distribution is needed since it contains the Rhino interpreter used for
running unit tests in the build and for creating compressed "builds" of Anzo.JS and Dojo.
