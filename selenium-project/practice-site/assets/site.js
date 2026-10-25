// SE2 Practice Lab — shared by every page
const PARAMS = new URLSearchParams(location.search);
const BUGS = PARAMS.get('bugs') === 'on';
function show(id, text) { const el = document.getElementById(id); el.textContent = text; el.classList.add('has-result'); }
(function () {
  let off = PARAMS.get('hints') === 'off';
  if (!PARAMS.has('hints')) { try { off = localStorage.getItem('se2-hints') === 'off'; } catch (e) {} }
  const btn = document.getElementById('toggle-hints');
  const apply = () => { document.body.classList.toggle('hints-off', off); btn.textContent = off ? 'Show hints' : 'Hide hints'; };
  btn.onclick = () => { off = !off; try { localStorage.setItem('se2-hints', off ? 'off' : 'on'); } catch (e) {} apply(); };
  apply();
  if (BUGS) {
    document.getElementById('bug-banner').hidden = false;
    document.querySelectorAll('#main-nav a').forEach(a => { a.href += (a.href.includes('?') ? '&' : '?') + 'bugs=on'; });
  }
})();
