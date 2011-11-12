Summary: OpenAnzo Server
Name: openanzo
Version: 3.2.0
Release: 1
License: EPL
Group: Applications/System
BuildRoot: %{_builddir}/%{name}-root 
URL: http://www.openanzo.org/
Vendor: OpenAnzo
Packager: Matthew Roy
Prefix: /opt
BuildArchitectures: noarch For java apps, you don’t care about the CPU architecture

%description
OpenAnzo Server

%prep
#wget http://build.openanzo.org/openanzo/downloads/snapshot/openanzo-3.1.0-SNAPSHOT-dist.tar.gz

%build
pwd

%install
pwd
rm -rf $RPM_BUILD_ROOT
mkdir -p $RPM_BUILD_ROOT/opt
cd $RPM_BUILD_ROOT/opt
tar -xzf $RPM_BUILD_ROOT/../openanzo-3.2.0-dist.tar.gz

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-,root,root)
/opt/openanzo-3.2.0/*

%changelog
* Fri Nov 14 2008 Mroy
- Created initial spec fileZ
