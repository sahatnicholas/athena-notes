#!/bin/bash
# Installs Square's IntelliJ configs into your user configs.

echo "This style is forked from Square IntelliJ configs (https://github.com/square/java-code-styles). All credits go to them."
echo ""
echo "Installing Euler IntelliJ configs..."

CONFIGS="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )/configs"

for i in $HOME/Library/Preferences/IntelliJIdea*  \
         $HOME/Library/Preferences/IdeaIC*        \
         $HOME/Library/Preferences/AndroidStudio* \
         $HOME/.IntelliJIdea*/config              \
         $HOME/.IdeaIC*/config                    \
         $HOME/.AndroidStudio*/config
do
  if [ -d $i ]; then

    # Install codestyles
    mkdir -p $i/codestyles
    cp -frv "$CONFIGS/codestyles"/* $i/codestyles

    # Install inspection
    mkdir -p $i/inspection
    cp -frv "$CONFIGS/inspection"/* $i/inspection

    # Install file header template
    mkdir -p $i/fileTemplates/includes
    cp -frv "$CONFIGS/fileTemplates/includes"/* $i/fileTemplates/includes
  fi
done

echo "Done."
echo ""
echo "Restart IntelliJ and/or AndroidStudio, go to preferences, and apply 'Euler'."
