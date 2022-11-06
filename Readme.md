comenzi incepatoare:
git config --global user.name Radu25
git config --global user.email radu.25201@gmail.com
git init

notepad Readme.md
git add .
git status
git commit

git remote add origin 'https://github.com/Radu25/An4Sem1IPLab3Exercitii'
git push -u origin master

git checkout -b mybranch
git status
git add .
git commit
git checkout master
git merge mybranch
git log --oneline --all --graph
git push -u origin main